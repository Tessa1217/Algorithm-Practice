function solution(nums) {
    const pickedPokemon = new Set();
    nums.forEach((num) => pickedPokemon.add(num));
    
    return Math.min(pickedPokemon.size, (nums.length / 2));
}