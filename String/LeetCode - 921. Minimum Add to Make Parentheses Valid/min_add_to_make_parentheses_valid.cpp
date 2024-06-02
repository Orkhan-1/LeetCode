#include <string>

//            C++
//     Time complexity - O (N)
//     Space complexity - O (1)

class MinimumAddToMakeParenthesesValid {
public:
    int minAddToMakeValid(const std::string& s) {
        int openParentheses = 0;
        int minAdd = 0;

        for (char c : s) {
            if (c == '(') {
                openParentheses++;
            } else if (c == ')') {
                if (openParentheses == 0) {
                    minAdd++;
                } else {
                    openParentheses--;
                }
            }
        }

        return minAdd + openParentheses;
    }
};
