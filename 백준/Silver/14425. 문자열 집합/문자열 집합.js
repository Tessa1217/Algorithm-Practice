const fs = require("fs");

const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const [n, m] = input[0].split(" ").map(Number);
const word_set = input.slice(1, n + 1);
const str_list = input.slice(n + 1, n + m + 1);

function word_in_set_cnt(word_set, word_list) {
  const set = new Set(word_set);
  let cnt = 0;
  for (let word of word_list) {
    cnt += set.has(word) ? 1 : 0;
  }
  return cnt;
}

console.log(word_in_set_cnt(word_set, str_list));
