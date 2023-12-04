import Collapse from 'bootstrap/js/dist/collapse';
import { arraysAreEqual, isCheckboxOrRadio } from '../../utils/functions';
import './accordion.scss';

function toggleCollapse(collapseEl, checked, show) {
  if (collapseEl) {
    const bsCollapse = Collapse.getInstance(collapseEl);

    if (checked) {
      if (show) {
        bsCollapse.show();
      } else {
        bsCollapse.hide();
      }
    }
  }
}

// collapse init
export function initCollapse(containerElement) {
  Array.from(containerElement.querySelectorAll('.collapse'))
    .forEach((collapseNode) => new Collapse(collapseNode, {
      toggle: false,
    }));
}

// collapse custom toggle
export function toggleCustomCollapse(containerElement) {
  const collapseGroup = {};

  Array.from(containerElement.querySelectorAll('[data-bs-collapse]'))
    .forEach((collapseNode) => {
      if (isCheckboxOrRadio(collapseNode)) {
        collapseNode.addEventListener('change', (e) => {
          const collapseId = e.target.dataset.bsCollapse;
          const bsTarget = e.target.dataset.bsTarget * 1;
          const collapseparentId = e.target.dataset.bsCollapseparent;
          const { checked } = e.target;

          if (collapseId.startsWith('#')) {
            const collapseEl = document.querySelector(collapseId);
            toggleCollapse(collapseEl, checked, bsTarget);
          } else if (collapseId.startsWith('.')) {
            // when collapseId is class name
            const collapseEls = document.querySelectorAll(collapseId);
            collapseEls.forEach((collapseEl) => toggleCollapse(collapseEl, checked, bsTarget));
          } else if (collapseId.length && collapseparentId) {
            // when collapse is group
            const accordion = document.querySelector(collapseparentId);
            const { name } = e.target;
            collapseGroup[name] = collapseId;
            const collapseEls = accordion.querySelectorAll('[data-collapsegroup-id]');
            const collapseGroupArr = Object.values(collapseGroup);

            collapseEls.forEach((collapseEl) => {
              const collapseGroupId = collapseEl.dataset.collapsegroupId;
              const collapseGroupIdArr = collapseGroupId.split(',');
              const trimedCollapseGroupIdArr = collapseGroupIdArr.map((item) => item.trim());
              const trimedCollapseGroupArr = collapseGroupArr.map((item) => item.trim());
              const collapseFrequency = collapseNode.dataset.bsFrequency;

              if (collapseFrequency) {
                trimedCollapseGroupArr.push(collapseFrequency);
              }

              if (arraysAreEqual(trimedCollapseGroupArr, trimedCollapseGroupIdArr)) {
                toggleCollapse(collapseEl, true, true);
              } else {
                toggleCollapse(collapseEl, true, false);
              }
            });
          }
        });
      } else {
        collapseNode.addEventListener('focus', (e) => {
          const collapseId = e.target.dataset.bsCollapse;
          const bsTarget = e.target.dataset.bsTarget * 1;

          if (collapseId.startsWith('#')) {
            const collapseEl = document.querySelector(collapseId);
            toggleCollapse(collapseEl, true, bsTarget);
          } else {
            // when collapseId is class name
            const collapseEls = document.querySelectorAll(collapseId);
            collapseEls.forEach((collapseEl) => toggleCollapse(collapseEl, true, bsTarget));
          }
        });
      }
    });
}
