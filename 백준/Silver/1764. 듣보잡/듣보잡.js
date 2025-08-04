const fs = require("fs");

const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const [n, m] = input[0].split(" ").map(Number);
const n_list = input.slice(1, n + 1);
const m_list = input.slice(n + 1, n + m + 1);

function find_duplicate_names(list1, list2) {
  const set2 = new Set(list2);
  const duplicates = list1.filter((ele) => set2.has(ele));
  console.log(duplicates.length);
  duplicates.sort();
  duplicates.forEach((d) => {
    console.log(d);
  });
}

find_duplicate_names(n_list, m_list);
