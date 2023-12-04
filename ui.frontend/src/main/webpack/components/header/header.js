import { isMobile } from '../../utils/functions';

import './header.scss';

const allowMouseOverForNav = () => {
  if (isMobile()) {
    return;
  }
  const navLinks = document.querySelectorAll('.nav-link');

  if (navLinks.length) {
    navLinks.forEach((navLink) => {
      navLink.removeAttribute('data-bs-toggle');
    });
  }
};

const handleDropdownHover = () => {
  if (isMobile()) {
    return;
  }
  let timeout;
  let openDropdown;

  const showDropdown = (element) => {
    clearTimeout(timeout);

    const navLink = element.querySelector('.nav-link');
    const dropdownMenu = element.querySelector('ul');

    if (navLink) {
      const chevronIcon = navLink.querySelector('i');

      navLink.classList.add('show');

      if (chevronIcon) {
        chevronIcon.classList.remove('fa-chevron-down');
        chevronIcon.classList.add('fa-chevron-up');
      }
    }

    if (dropdownMenu?.classList?.contains('multi-column')) {
      dropdownMenu.setAttribute('data-bs-popper', 'static');
    }

    if (openDropdown) {
      openDropdown.querySelector('.dropdown-menu')
        .classList
        .remove('show');
    }

    if (openDropdown != null && openDropdown !== element) {
      if (navLink) {
        const openDropdownNavLink = openDropdown.querySelector('.nav-link');
        const chevronIcon = openDropdownNavLink.querySelector('i');

        openDropdownNavLink.classList.remove('show');

        if (chevronIcon) {
          chevronIcon.classList.remove('fa-chevron-up');
          chevronIcon.classList.add('fa-chevron-down');
        }
      }
    }
    element.querySelector('.dropdown-menu')
      ?.classList
      .add('show');

    openDropdown = element;
  };

  const hideDropdown = (element) => {
    const navLink = element.querySelector('.nav-link');

    timeout = setTimeout(() => {
      element.querySelector('.dropdown-menu')
        ?.classList
        .remove('show');

      if (navLink) {
        const chevronIcon = navLink.querySelector('i');

        navLink.classList.remove('show');

        if (chevronIcon) {
          chevronIcon.classList.remove('fa-chevron-up');
          chevronIcon.classList.add('fa-chevron-down');
        }
      }
    }, 500);
  };

  document.querySelectorAll('.nav-item.dropdown')
    .forEach((dropdown) => {
      dropdown.addEventListener('mouseenter', () => showDropdown(dropdown));
      dropdown.addEventListener('mouseleave', () => hideDropdown(dropdown));
    });
};

const handleBtnSearch = () => {
  const btnSearch = document.querySelector('.btn-search');
  const searchInputContainer = document.querySelector('.search-input-desktop');

  if (btnSearch) {
    btnSearch.addEventListener('click', () => {
      const searchIcon = btnSearch.querySelector('i');

      if (searchIcon && searchInputContainer) {
        const searchInput = searchInputContainer.querySelector('input');

        if (searchIcon.classList.contains('fa-search')) {
          searchIcon.classList.remove('fa-search');
          searchIcon.classList.add('fa-times');
          searchInputContainer.classList.remove('d-none');

          if (searchIcon) {
            searchInput.focus();
          }
        } else {
          searchIcon.classList.remove('fa-times');
          searchIcon.classList.add('fa-search');
          searchInputContainer.classList.add('d-none');
        }
      }
    });
  }
};

const handleNavWhenScrolling = () => {
  const { $ } = window;
  const headerContainerClass = '.tch-header-container';
  let lastScrollTop = 0;

  if (isMobile()) {
    $(headerContainerClass)
      .removeClass('fixed-top');

    return;
  }

  $(window)
    .scroll((e) => {
      const scrollTop = $(e.target)
        .scrollTop();

      if (scrollTop > lastScrollTop) {
        $(headerContainerClass)
          .addClass('hidden');
      } else {
        $(headerContainerClass)
          .removeClass('hidden');
      }

      if (scrollTop === 0) {
        $(headerContainerClass)
          .addClass('inherit');
      } else {
        $(headerContainerClass)
          .addClass('bg-light');
      }
      lastScrollTop = scrollTop;
    });
};

document.addEventListener('DOMContentLoaded', () => {
  const mainHeader = document.querySelector('.main-header');
  const toggleBtn = document.getElementById('toggle-btn');
  const navbarBrand = document.querySelector('.navbar-brand');
  const navbarCollapse = document.getElementById('navbarCollapse');
  const navbarDonateButtonMobile = document.querySelector('.nav-donate-button-mobile');

  if (toggleBtn && navbarCollapse) {
    toggleBtn.addEventListener('click', () => {
      toggleBtn.classList.toggle('open');
      navbarCollapse.classList.toggle('show');

      if (mainHeader && navbarCollapse.classList.contains('show')) {
        mainHeader.classList.add('header-fixed');
      } else {
        mainHeader.classList.remove('header-fixed');
      }

      if (navbarDonateButtonMobile) {
        navbarDonateButtonMobile.classList.toggle('invisible');
      }

      if (navbarBrand) {
        navbarBrand.classList.toggle('invisible');
      }
    });
  }
  // Allow mouseover only for desktop
  allowMouseOverForNav();

  // Handle dropdown mouse over
  handleDropdownHover();

  // Handle search button click
  handleBtnSearch();

  // Handle nav when scrolling
  handleNavWhenScrolling();
});
