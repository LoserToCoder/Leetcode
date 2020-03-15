/**
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
*/
public int longestValidParentheses(String s) {
        
		if(s==null||s.length()<=0)
			return 0;
		int len=0;
		int maxlen=0;
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(-1);//初始化栈
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(ch=='('){
				stack.push(i);
			}else{
				stack.pop();
				if(stack.isEmpty()){
					stack.push(i);
				}
				len=i-stack.peek();
				maxlen=Math.max(maxlen,len);
			}
		}
		return maxlen;
}
/**
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
示例 1:
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
**/
 public int lengthOfLongestSubstring(String s) {
		 if(s==null||s.length()==0) return 0;
		 Map<Character,Integer> map=new HashMap<Character, Integer>();
		 int maxlen=0;
		 for(int i=0,j=0;i<s.length();i++){
			 char ch=s.charAt(i);
			 if(map.containsKey(ch)){
				 j=Math.max(map.get(ch),j);//更新索引最大的位置
			 }
			 map.put(ch, i);
			 maxlen=Math.max(maxlen,i-j+1);
		 }
		 return maxlen;
}

给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
示例 1:
输入: [2,2,1]
输出: 1
示例 2:
输入: [4,1,2,1,2]
输出: 4
链接：https://leetcode-cn.com/problems/single-number

 public int singleNumber(int[]nums){
 	int res=0;
 	for(int item:nums) res^=item; 
 	return res;
 }
