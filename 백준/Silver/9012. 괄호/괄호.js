const fs = require("fs");

const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const n = input[0];
const parentheses = [];

for (let i = 1; i <= n; i++) {
  parentheses.push(input[i].split(""));
}

function check_parenthesis(ps) {
  const check_stack = [];
  for (let p of ps) {
    if (p === "(") {
      check_stack.push(p);
      continue;
    }
    if (check_stack[check_stack.length - 1] !== "(") {
      return false;
    }
    check_stack.pop();
  }

  return check_stack.length === 0;
}

parentheses.forEach((ps) =>
  check_parenthesis(ps) ? console.log("YES") : console.log("NO")
);
