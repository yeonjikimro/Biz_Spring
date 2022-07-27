document.addEventListener("DOMContentLoaded", () => {
  const list_table = document.querySelector("table.list");

  list_table?.addEventListener("click", (e) => {
    const td = e.target;
    if (td.tagName === "TD") {
      const tr = td.closest("TR");
      const a_seq = tr.dataset.seq;
      document.location.href = `${rootPath}/detail?seq=${a_seq}`;
    }
  });
});
