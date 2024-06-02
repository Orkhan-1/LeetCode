//             JS
//     Time complexity - O (N)
//     Space complexity - O (1)

var minAddToMakeValid = function minAddToMakeValid(s) {
    let openParentheses = 0;
    let minAdd = 0;

    for (let char of s) {
        if (char === '(') {
            openParentheses++;
        } else if (char === ')') {
            if (openParentheses === 0) {
                minAdd++;
            } else {
                openParentheses--;
            }
        }
    }

    return minAdd + openParentheses;
};