const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const n = Number(input[0])
const order = input.slice(1, n + 1).map((order_str) => order_str.split(" "))

function run_command(o, stack, command) {    
    const [key, value] = o
    if (key === '1') {
        stack.push(value)
    } else if (key === '2') {
        command.push(stack.length ? stack.pop() : -1)        
    } else if (key === '3') {
        command.push(stack.length)        
    } else if (key === '4') {
        command.push(stack.length ? 0 : 1)        
    } else if (key === '5') {
        command.push(stack.length ? stack[stack.length - 1] : -1)        
    }
}

const stack = []
const command = []
order.forEach((o) => run_command(o, stack, command))
console.log(command.join("\n"))