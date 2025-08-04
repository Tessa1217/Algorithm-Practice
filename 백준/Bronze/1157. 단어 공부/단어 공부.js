const fs = require("fs");

const word = fs.readFileSync("/dev/stdin").toString().trim();

function study_word(word) {
  const word_map = {};
  word.toUpperCase().split("").forEach((key) => {
      word_map[key] = (word_map[key] || 0) + 1
  })
  
  const word_checker = Object.values(word_map).sort((a, b) => b - a);
  if (word_checker[0] == word_checker[1]) {
      return "?";
  }
  return Object.keys(word_map).find((key) => word_map[key] === word_checker[0])  
}

console.log(study_word(word));