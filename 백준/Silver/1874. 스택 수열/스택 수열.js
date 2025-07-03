let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let n = Number(input[0]);
let sequence = [];

for (let i = 1; i < input.length; i++) {
    if (input[i] !== '') {        
        sequence.push(Number(input[i]))
    }
}

function stack_sequence(n, sequence) {
    
    let stack_seq = []
    let operators = []
    let sequence_index = 0
    
    for (let i = 1; i <= n; i++) {
        stack_seq.push(i);
        operators.push('+');     
        while(
          stack_seq.length &&
            stack_seq[stack_seq.length - 1] === sequence[sequence_index]
        ) {
          stack_seq.pop();
          sequence_index++;
          operators.push('-')
        }       
    }
    
    if (stack_seq.length) {
        console.log("NO");
    } else {
        console.log(operators.join("\n"))
    }
}

stack_sequence(n, sequence);




