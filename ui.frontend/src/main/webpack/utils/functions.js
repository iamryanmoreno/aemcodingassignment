/**
 * util functions
 */

// Check if the input is checkbox or radio
export function isCheckboxOrRadio(element) {
  if (element.tagName.toLowerCase() === 'input') {
    const type = element.type.toLowerCase();
    return type === 'checkbox' || type === 'radio';
  }
  return false;
}

// Get element's inner width without it's paddings
export function getElementInnerWidth(element) {
  if (element) {
    const width = element.offsetWidth;
    const styles = window.getComputedStyle(element);
    const paddingRight = parseFloat(styles.paddingRight);
    const paddingLeft = parseFloat(styles.paddingLeft);

    return width - (paddingLeft + paddingRight);
  }
  return 0;
}

// Compare two arrays are equal
export function arraysAreEqual(arr1, arr2) {
  if (arr1.length !== arr2.length) {
    return false;
  }

  const sortedArr1 = arr1.slice().sort();
  const sortedArr2 = arr2.slice().sort();

  for (let i = 0; i < sortedArr1.length; i += 1) {
    if (sortedArr1[i] !== sortedArr2[i]) {
      return false;
    }
  }

  return true;
}

// Scroll to the element
export const scrollToElement = (element, shouldFocus = false) => {
  element.scrollIntoView({
    behavior: 'smooth',
    block: 'center',
  });

  if (shouldFocus) {
    setTimeout(() => {
      element.focus();
    });
  }
};

// Set input validation class
export const setInputValidationClass = (input, isValid) => {
  if (isValid) {
    input.classList.remove('is-invalid');
    input.classList.add('is-valid');
  } else {
    input.classList.remove('is-valid');
    input.classList.add('is-invalid');
  }
};

// Get query params from url
export const getQueryParamsAsObj = (searchQueryString) => {
  const queryString = searchQueryString.slice(1);
  const params = {};

  queryString.split('&').forEach((pair) => {
    const [key, value] = pair.split('=');

    if (key && value) {
      params[decodeURIComponent(key)] = encodeURIComponent(value);
    }
  });

  return params;
};

// Convert to comma seperated amount
export const formatAmountWithCommaSeparated = (amount) => {
  if (amount) {
    const numberFormat = new Intl.NumberFormat('en-US', {
      style: 'currency',
      currency: 'SGD',
    });
    const parts = numberFormat.formatToParts(amount);
    const partValues = parts.map((p) => p.value);

    return partValues.slice(2).join('').replace('.00', '');
  }

  return 0;
};

// Debounce function
export const debounce = (func, delay) => {
  let timeout;

  return (...args) => {
    clearTimeout(timeout);

    timeout = setTimeout(() => {
      func.apply(this, args);
    }, delay);
  };
};

// Check whether a device is a mobile
export const isMobile = () => ('ontouchstart' in document.documentElement && /mobi/i.test(navigator.userAgent));
