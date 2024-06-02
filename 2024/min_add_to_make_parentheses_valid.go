package main

//            Go
//     Time complexity - O (N)
//     Space complexity - O (1)

func minAddToMakeValid(s string) int {
	openParentheses := 0
	minAdd := 0

	for _, char := range s {
		if char == '(' {
			openParentheses++
		} else if char == ')' {
			if openParentheses == 0 {
				minAdd++
			} else {
				openParentheses--
			}
		}
	}

	return minAdd + openParentheses
}
