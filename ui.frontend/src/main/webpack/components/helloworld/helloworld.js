// Example of how a component should be initialized via JavaScript
// This script logs the value of the component's text property model message to the console
import './helloworld.scss';

(() => {
  // Best practice:
  // For a good separation of concerns, don't rely on the DOM structure or CSS selectors,
  // but use dedicated data attributes to identify all elements that the script needs to
  // interact with.
  const selectors = {
    self: '[data-cmp-is="helloworld"]',
    property: '[data-cmp-hook-helloworld="property"]',
    message: '[data-cmp-hook-helloworld="model"]',
  };

  function HelloWorld(_config) {
    function init(config) {
      let property = config.element.querySelectorAll(selectors.property);
      let model = config.element.querySelectorAll(selectors.message);

      // Best practice:
      // To prevents multiple initialization, remove the main data attribute that
      // identified the component.
      config.element.removeAttribute('data-cmp-is');
      property = property.length === 1 ? property[0].textContent : null;
      model = model.length === 1 ? model[0].textContent : null;

      /* eslint-disable no-console */
      if (console && console.log) {
        console.log(
          'HelloWorld component JavaScript example',
          '\nText property:\n',
          property,
          '\nModel message:\n',
          model,
        );
      }
      /* eslint-disable no-console */
    }

    if (_config && _config.element) {
      init(_config);
    }
  }

  // Best practice:
  // Use a method like this mutation obeserver to also properly initialize the component
  // when an author drops it onto the page or modified it with the dialog.
  function onDocumentReady() {
    const elements = document.querySelectorAll(selectors.self);
    const MutationObserver = window.MutationObserver || window.WebKitMutationObserver || window.MozMutationObserver;
    const body = document.querySelector('body');
    const observer = new MutationObserver((mutations) => {
      mutations.forEach((mutation) => {
        // needed for IE
        const nodesArray = [].slice.call(mutation.addedNodes);
        if (nodesArray.length > 0) {
          nodesArray.forEach((addedNode) => {
            if (addedNode.querySelectorAll) {
              const elementsArray = [].slice.call(addedNode.querySelectorAll(selectors.self));
              elementsArray.forEach((element) => {
                (() => new HelloWorld({ element }))();
              });
            }
          });
        }
      });
    });

    for (let i = 0; i < elements.length; i += 1) {
      (() => new HelloWorld({ element: elements[i] }))();
    }

    observer.observe(body, {
      subtree: true,
      childList: true,
      characterData: true,
    });
  }

  if (document.readyState !== 'loading') {
    onDocumentReady();
  } else {
    document.addEventListener('DOMContentLoaded', onDocumentReady);
  }
})();
