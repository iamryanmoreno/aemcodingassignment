import './loader.scss';

const showLoader = (loaderContainer) => {
  if (loaderContainer) {
    loaderContainer.classList.remove('d-none');
    loaderContainer.classList.add('d-flex');
    document.body.style.overflow = 'hidden';
  }
};

const hideLoader = (loaderContainer) => {
  if (loaderContainer) {
    loaderContainer.classList.add('d-none');
    document.body.style.overflow = 'auto';
  }
};

export {
  showLoader,
  hideLoader,
};
