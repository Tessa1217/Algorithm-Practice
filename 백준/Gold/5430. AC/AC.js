const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const testcase = Number(input[0]);
const print = [];
for (let i = 1; i <= testcase * 3; i += 3) {
  const commands = filter_command(input[i].split(""));
  const delete_command = commands.filter((c) => c === "D");
  const n = Number(input[i + 1]);
  if (delete_command.length > n) {
    print.push("error");
    continue;
  }

  const arr = input[i + 2].slice(1, -1).split(",");
  let reversed = false;
  for (let c of commands) {
    if (c === "R") {
      reversed = !reversed;
    } else if (c === "D") {
      if (!reversed) {
        arr.splice(0, 1);
      } else {
        arr.splice(-1, 1);
      }
    }
  }

  if (reversed) {
    arr.reverse();
  }
  print.push(`[${arr.join(",")}]`);
}

function filter_command(command) {
  const filter_stack = [];
  for (let c of command) {
    if (
      c === "R" &&
      filter_stack.length &&
      filter_stack[filter_stack.length - 1] === "R"
    ) {
      filter_stack.pop();
    } else {
      filter_stack.push(c);
    }
  }
  return filter_stack;
}

console.log(print.join("\n"));
