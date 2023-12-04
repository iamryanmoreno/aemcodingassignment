import Carousel from 'bootstrap/js/dist/carousel';
import './carousel.scss';

// carousel init
export function initCarousel(containerElement) {
  Array.from(containerElement.querySelectorAll('.carousel'))
    .forEach((carouselNode) => new Carousel(carouselNode));
}

// banner carousel
export function slideCustomCarousel(containerElement) {
  Array.from(containerElement.querySelectorAll('[data-bs-carousel]'))
    .forEach((carouselNode) => {
      carouselNode.addEventListener('change', (e) => {
        const carouselId = e.target.dataset.bsCarousel;
        const bsTarget = e.target.dataset.bsTarget * 1;
        const { checked } = e.target;

        const carouselEl = document.getElementById(carouselId);

        if (carouselEl) {
          const bsCarousel = Carousel.getInstance(carouselEl);

          if (checked) {
            bsCarousel.to(bsTarget);
          }
        }
      });
    });
}
