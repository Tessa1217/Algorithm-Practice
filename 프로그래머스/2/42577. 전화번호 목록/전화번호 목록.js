function solution(phone_book) {
    phone_book.sort();
    return !phone_book.some((book, idx) => phone_book[idx + 1]?.startsWith(book));
}