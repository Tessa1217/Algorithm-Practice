let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");

const N = Number(input[0])

const sketchbook = Array.from(Array(100), () => new Array(100))

let answer = 0;

for (let i = 0; i < N; i++) {
    const [paper_x, paper_y] = input[i + 1].split(" ").map(Number);
    for (let x = paper_x; x < paper_x + 10; x++) {
        for (let y = paper_y; y < paper_y + 10; y++) {
            if (sketchbook[x][y]) {
                continue;
            }
            sketchbook[x][y] = 1
            answer += 1;
        }
    }
}

console.log(answer)