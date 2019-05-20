package all;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.swing.tree.TreeNode;


public class Test {
	
	//**// 1.Jewels and Stones //**//
	int numberJewelaStones(String j, String s) {
		char[] x = j.toCharArray();
		char[] m = s.toCharArray();
		
		ArrayList<Character> al = new ArrayList<Character>();
		
		for(char c : m)
			al.add(c);
		
		int count = 0;
		for(int i = 0; i < x.length; i++) {
			while(al.contains(x[i])) {
				count++;
				al.remove(al.indexOf(x[i]));
			}
		}
		
		return count++;
	}
	
	
	//**// 2.Unique Morse Code Words //**//
	int uniqueMorseRepresentations(String[] s) {
		String[] d = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", 
				"-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", 
				"...-", ".--", "-..-", "-.--", "--.."};
		
		HashSet<String> hs = new HashSet<String>();
		
		for(String str : s) {
			String done = "";
			for(char c : str.toCharArray())
				done += d[c - 'a'];
			hs.add(done);
		}
		return hs.size();
    }
	
	
	//**// 3.Hamming Distance //**//
	int hammingDistance(int x, int y) {
		int m = x^y;
		int bits = 0;
		while(m > 0) {
			bits += m & 1;
			m >>= 1;
		}
		return bits;
    }
	
	
	//**// 6. Self Dividing Numbers //**//
	public ArrayList<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        
        for(int i = left; i <= right; i++) {
        	int x = i;
        	int count = 0;
        	while (x > 0) {
        		int k = x%10;
        		x /= 10;
        		if ( k == 0 || i%k != 0)
        			break;
        		else count++;
        	}
        	String m = String.valueOf(i);
        	if (count == m.length())
        		al.add(i);
        }
        return al;
    }
	
	//**// 7. Array Partition I //**//
	int arrayPairSum(int[] nums) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        
        for(Integer n : nums) 
        	al.add(n);
        
        Collections.sort(al);
        
        int sum = 0;
        for(int i = 0; i < al.size(); i+=2) {
        	sum += al.get(i);
        }
        return sum;
    }
	
	
	//**// 8. Goat Latin //**//
	public String toGoatLatin(String S) {
        
		ArrayList<String> al = new ArrayList<String>();
		
		for(String x : S.split("\\s+"))
        	al.add(x);
		
		String result = "";
		String ma = "ma";
		for(int i = 0; i < al.size(); i++) {
			char[] x = al.get(i).toCharArray();
			ma += 'a';
			String done = "";
			StringBuilder sb = null;
			if (x[0] != 'a' && x[0] != 'A' && x [0] != 'i' && x[0] != 'I' 
					&& x[0] != 'e' && x[0] != 'E' && x [0] != 'o' && x[0] != 'O' 
					&& x [0] != 'u' && x[0] != 'U') {
				for(int j = 1; j < x.length; j++) {
					sb = new StringBuilder();
					sb.append(x[j]);
					done += sb.toString();
				}
				done += x[0] + ma;
				result += done + " ";
			} else {
				done = al.get(i);
				done += ma;
				result += done + " ";
			}
		}
		return result;
    }
	
	
	//**// 9. Toeplitz Matrix //**//
	boolean isToeplitzMatrix(int[][] a) {
		for(int i = 0; i < a.length-1; i++) {
			for(int j = 0; j < a.length-1; j++) {
				if (a[i][j] != a[i+1][j+1])
					return false;
			}
		}
		return true;
    }
	
	
	//**// 10. Number Complement //**//
	int findComplement(int num) {
        String m = Integer.toBinaryString(num);
        
        char[] ch = m.toCharArray();
        
        String done = "";
        for(int i = 0; i < ch.length; i++) {
        	if (ch[i] == '0')
        		done += "1";
        	else done += "0";
        }
        
        num = Integer.parseInt(done);
        if (num == 0)
        	return 0;
        return String.valueOf(num).length();
    }
	
	
	//**// 11. Flipping an Image //**//
	public static int[][] flipAndInvertImage(int[][] A) {
        int r = A.length;
        int c = A[0].length;
        int m[][] = new int[r][c];
        
        for(int i = 0; i < r;i++) {
        	for(int j = 0; j < c; j++) {
        		m[i][j] = A[i][c-j-1];
        	}
        }
        
        for (int i = 0; i < r; i++) {
        	for (int j = 0; j < c; j++) {
        		if (m[i][j] == 0)
        			m[i][j] = 1;
        		else m[i][j] = 0;
        	}
        }
        
        return m;
    }
	
	
	//**// 12. Reverse Words in a String III //**//
	public String reverseWords(String s) {
        ArrayList<String> al = new ArrayList<String>();
        
        for(String c : s.split("\\s+"))
        	al.add(c);
        String done = "";
        for(int i = 0; i < al.size(); i++) {
        	char[] x = al.get(i).toCharArray();
        	for(int j = x.length-1; j >= 0; j--)
        		done += x[j];
        	done += " ";
        }
        return done;
    }
	
	
	//**// 13. Reverse String //**//
	public void reverseString(char[] s) {
        char temp;
        for(int i = 0; i < (s.length/2); i++) {
        	temp = s[s.length-1-i];
        	s[s.length-1-i] = s[i];
        	s[i] = temp;
        }
    }
	
	
	//**// 14. Backspace String Compare //**//
	public String convert(String m) {
		ArrayList<Character> al = new ArrayList<Character>();
		
		char[] x = m.toCharArray();
		for(int i = 0; i < x.length; i++)
			al.add(x[i]);
		
		while(al.contains('#')) {
			for(int i = 0; i < al.size()-1; i++) {
				if(al.get(i) == '#' && i == 0) {
					al.remove(i);
					if (al.size() == 1)
						break;
				}
				if (al.get(i+1) == '#') {
					al.remove(i+1);
					al.remove(i);
					if (al.size() == 1)
						break;
				}
			}
		}
		
		StringBuilder sb = null;
		String done = null;
		for(int i = 0; i < al.size(); i++) {
			sb = new StringBuilder();
			sb.append(al.get(i));
			if (done == null)
				done = sb.toString();
			else done += sb.toString();
		}
		if (done == null)
			return null;
		else return done;
	}

	
	public boolean backspaceCompare(String S, String T) {
		String s1 = convert(S);
		String t1 = convert(T);
		if (s1 == null && t1 == null)
			return true;
		if (s1.equalsIgnoreCase(t1))
			return true;
		return false;
    }
	
	
	//**// 15. Keyboard Row //**//
	public boolean keyboard(String a1) {
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		for(char letter : "qwertyuiop".toCharArray())
			m.put(letter, 1);
		for(char letter : "asdfghjkl".toCharArray())
			m.put(letter, 2);
		for(char letter : "zxcvbnm".toCharArray())
			m.put(letter, 3);
		
		String lower = a1.toLowerCase();
		int ctgr = m.get(lower.charAt(0));
		boolean same = true;
		for(char letter : lower.toCharArray()) {
			if (m.get(letter) != ctgr) {
				same = false;
				break;
			}
		}
		return same;
	}
	
	public ArrayList<String> findWords(String[] words) {
		ArrayList<String> al = new ArrayList<String>();
		for(int i = 0; i < words.length; i++) {
			if (keyboard(words[i]) == true)
				al.add(words[i]);
		}
		return al;
    }
	
	
	//**// 16. Baseball Game //**//
	public int calPoints(String[] ops) {
		int sum = 0;
		int pre = 0;
		int next = 0;
		for(int i = 0; i < ops.length; i++) {
			if (ops[i].matches("[0-9]*") || ops[i].matches("-?[1-9]*")) {
				sum += Integer.parseInt(ops[i]);
				pre = next;
				next = Integer.parseInt(ops[i]);
			}
			if (ops[i].matches("D")) {
				sum += next*2;
				pre = next;
				next = pre*2;
			}
			if (ops[i].matches("C")) {
				sum -= next;
				next = pre;
			}
			if (ops[i].matches("[+]")) {
				sum += next + pre;
				int temp = next;
				next = next + pre;
				pre = temp;		
			}
		}
		return sum;
	}
	
	
	//**// 18. Fizz Buzz //**// 
	public ArrayList<String> fizzBuzz(int n) {
		ArrayList<String> al = new ArrayList<String>();
		for(int i = 1; i <= n; i++) {
			if (i%3 == 0 && i%5 == 0)
				al.add("FizzBuzz");
			else if (i%3 == 0)
				al.add("Fizz");
			else if (i%5 == 0)
				al.add("Buzz");
			else al.add(String.valueOf(i));
		}
		return al;
    }
	
	
	//**// 19. Distribute Candies //**//
	public int distributeCandies(int[] candies) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (Integer i : candies)
			al.add(i);
		
		for(int i = 0; i < al.size() - 1; i++) {
			for(int j = i+1; j < al.size(); j++) {
				if (al.get(i) == al.get(j))
					al.remove(j);
			}
		}
		
		if (al.size() > candies.length/2)
			return candies.length/2;
		else if (al.size() <= candies.length/2)
			return al.size();
		return 0;
    }
	
	
	//**// 21. Peak Index in a Mountain Array //**//
	public int peakIndexInMountainArray(int[] A) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (Integer i : A)
			al.add(i);
		
		int max = al.get(0);
		int smax = 0;
		for(int i = 1; i < al.size(); i++) {
			if (al.get(i) > max) {
				max = al.get(i);
				smax = i;
			}
		}
		return smax;
    }
	
	
	//**// 23. Transpose Matrix //**//
	public int[][] transpose(int[][] A) {
		int r = A.length;
		int c = A[0].length;
		int[][] m = new int[c][r];
		for (int j = 0; j < c; j++) {
			for (int i = 0; i < r; i++)
				m[j][i] = A[i][j];
		}
		return m;
    }
	
	
	//**// 24. Prime Number of Set Bits in Binary Representation //**//
	public int countPrimeSetBits(int L, int R) {
		int sd = 0;
		for (int i = L; i <= R; i++) {
			String m = Integer.toBinaryString(i);
			char[] x = m.toCharArray();
			int count = 0;
			for(int j = 0; j < x.length; j++) {
				if (x[j] == '1') {
					count++;
				}
			}
			if (check(count))
				sd++;
		}
		return sd;
    }
	
	public boolean check(int n) {
		int i, m = 0, flag = 0;
		m = n/2;
		if (n==0 || n == 1)
			return false;
		else {
			for(i = 2; i <= m; i++) 
				if (n%i == 0)
					return false;
		}
		return true;
	}
	
	
	//**// 25. Next Greater Element I //**//
	public ArrayList<Integer> nextGreaterElement(int[] nums1, int[] nums2) {
       ArrayList<Integer> al = new ArrayList<Integer>();
       for(int i = 0; i < nums1.length; i++) {
			for(int j = 0; j < nums2.length; j++) {
				if (nums1[i] == nums2[j] && j < nums2.length-1) {
					if (nums2[j+1] > nums2[j])
						al.add(nums2[j+1]);
					else al.add(-1);
				}
				if (nums1[i] == nums2[j] && j == nums2.length-1)
					al.add(-1);
			}
		}
       
       return al;
    }
	
	
	//**// 28. Binary Number with Alternating Bits //**//
	public boolean hasAlternatingBits(int n) {
    	String m = Integer.toBinaryString(n);

		for(int i = 0; i < m.length()-1; i++) {
			if (m.charAt(i) == m.charAt(i+1)) {
				return false;
			}
		}
		return true;
    }
	
	
//	//**// 23. Middle of the Linked List //**//
//	public ListNode middleNode(ListNode head) {
//        if (head == null)
//        	return head;
//        ListNode f = head.next;
//        ListNode s = head;
//        while (f != null) {
//        	s = s.next;
//        	if (f.next == null)
//        		f = f.next;
//        	else f = f.next.next;
//        }
//        return s;
//    }
	
	
	//**// 30. Nim Game //**// 
	public static boolean canWinNim(int n) {
		if (n%4 == 0)
			return false;
		return true;
    }
	
	
	//**// 31. Single Number //**//
	public int singleNumber(int[] nums) {
        ArrayList<Integer> al = new ArrayList<Integer>();
		for (Integer i : nums) {
			if (!al.contains(i))
				al.add(i);
			else 
				al.remove(al.indexOf(i));
		}
		
		int x = al.get(0);
		return x;
    }
	
	
	//**// 33. Max Consecutive Ones //**//
	public int findMaxConsecutiveOnes(int[] nums) {
    	int max = 0;
		for(int i = 0; i < nums.length-1; i++) {
			if (nums[i] == 1) {
				int count = 1;
				for(int j = i+1; j < nums.length; j++) {
					if (nums[j] == 1){
						count++;
						if (count > max)
							max = count;
					}
					else break;
				}
			}
		}
		
		return max;
    }
	
	
	//**// 34. Uncommon Words from Two Sentences //**//
	public ArrayList<String> uncommonFromSentences(String A, String B) {
		ArrayList<String> al = new ArrayList<String>();
		String[] s1 = A.split("\\s+");
		for(String c : s1) {
			if (!al.contains(c)) {
				al.add(c);
			} else {
				al.remove(al.indexOf(c));
			}
		}
		
		s1 = B.split("\\s+");
		for(String c : s1) {
			if (!al.contains(c)) {
				al.add(c);
			} else {
				al.remove(al.indexOf(c));
			}
		}
		
		return al;
	}
	
	
	//**// 38. Detect Capital //**//
	public boolean detectCapitalUse(String word) {
		int count = 0;
        for(int i = 0; i < word.length(); i++) {
        	if(Character.isUpperCase(word.charAt(i)))
        		count++;
        }
        if (count == word.length() || count == 0)
        	return true;
        if (count == 1 && Character.isUpperCase(word.charAt(0)))
        	return true;
        return false;
    }
	
	
	//**// 39. Add Digits //**//
	public int addDigits(int num) {
    	if (num == 0)
			return 0;
		return (num - 1) % 9 + 1;
    }
	
	
	//**// 40. Count Binary Substrings //**//s
	public int countBinarySubstrings(String s) {
    	int pre = 0, cur = 1, res = 0;
		for(int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i-1))
				cur++;
			else {
				pre = cur;
				cur = 1;
			}
			if (pre >= cur)
				res++;
		}
		return res;
    }
	
	
	//**// 41. Find All Numbers Disappeared in an Array //**//
	public ArrayList<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> al = new ArrayList<Integer>();
    	for(int i = 0; i < nums.length; i++) {
    		int count = 0;
    		for(int j = 0; j < nums.length; j++) {
    			if (nums[j] == i+1)
    				count++;
    		}
    		if (count == 0)
    			al.add(i+1);
    	}
    	
    	return al;
    }
	
	
	//**// 42. Move Zeroes //**//
	public void moveZeroes(int[] nums) {
        ArrayList<Integer> al = new ArrayList<Integer>();
		for(Integer i : nums) {
        	if (i != 0)
        		al.add(i);
        }
		
		while (al.size() < nums.length)
			al.add(0);
		
		System.out.println(al);
    }
	
	
	//**// 43. Find the Difference //**//
	public char findTheDifference(String s, String t) {
        int sumS = 0, sumT = 0;
    	for(char c : s.toCharArray())
        	sumS += (int) c;
    	for(char c : t.toCharArray())
    		sumT += (int) c;
    	
    	return (char) (sumT-sumS);
    }
	
	
	//**// 44. Sum of Two Integers //**//
	public int getSum(int a, int b) {
        return a+b;
    }
	
	
	//**// 45. Two Sum IV - Input is a BST //**//
//	public boolean findTarget(Node root, int x) {
//		if (root == null)
//			return false;
//		if (search(root, x-root.info) != 0)
//			return true;
//		find(root.left, x);
//		find(root.right, x);
//		return false;
//	}
//	
//	int search(Node root, int x) {
//		if(root == null)
//			return 0;
//		if(x == root.info)
//			return root.info;
//		if(x < root.info) 
//			return search(root.left, x);
//		return search(root.right, x);
//	}
	
	
	//**// 47. 1-bit and 2-bit Characters //**// 
	public boolean isOneBitCharacter(int[] bits) {
    	String m = "";
    	for(int i : bits)
    		m += String.valueOf(i);
        int i = 0;
        boolean z = false;
		while (i < m.length()) {
			if (m.charAt(i) == '1') {
				if (m.charAt(i+1) == '1' || m.charAt(i+1) == '0') {
					z = false;
					if ((i+1) == m.length()-1)
						break;
					else i+=2;
				}
			}
			if (m.charAt(i) == '0') {
				z = true;
				i++;
			}
		}
		if (z) return true;
		else return false;
	}
	
	
	//**// 48. Convert BST to Greater Tree //**//
//	int prev = 0;
//    public TreeNode convertBST(TreeNode root) {
//        if (root == null)
//        	return null;
//        convertBST(root.right);
//        root.val += prev;
//        prev = root.val;
//        convertBST(root.left);
//        return root;
//    }
	
	
	//**// 49. Monotonic Array //**//
	public boolean isMonotonic(int[] A) {
        if (A[0] < A[1]) {
        	for(int i = 1; i <  A.length-1; i++) {
        		if (A[i] > A[i+1])
        			return false;
        	}
        } else {
        	for (int i = 1; i < A.length-1; i++) {
        		if (A[i] < A[i+1])
        			return false;
        	}
        }
        return true;
    }
	
	
	//**// 51. Construct the Rectangle //**//
	public int[] constructRectangle(int area) {
    	int s1 = 0, s2 = 0, h = area, ht = 0;
		for(int i = 1; i < area ; i ++) {
			if (area%i == 0) {
				int temp = area /i;
				if (i >= temp)
					ht = i - temp;
				else ht = temp - i;
				if (ht < h) {
					s1 = i;
					s2 = temp;
					h = ht;
				}
			}
		}
		
		int[] result = {s1,s2};
		return result;
    }
	
	
	//**// 52. Excel Sheet Column Number //**//
	public int titleToNumber(String s) {
        int x = 26, sum = 0;
        for(int i = 0; i < s.length(); i++) {
        	sum = sum*x + (s.charAt(i) - 'A' + 1);
        }
        return sum;
    }
	
	
	//**// 54. Minimum Moves to Equal Array Elements //**//
	public int minMoves(int[] nums) {
        int x = nums[0];
        for(int i : nums) {
        	if (x > i)
        		x = i;
        }
        
        int result = 0;
        for(int m : nums) {
        	result += (m - x);
        }
        return result;
    }
	
	
	//**// 55. Intersection of Two Arrays //**//
	public ArrayList<Integer> intersection(int[] nums1, int[] nums2) {
    	ArrayList<Integer> al = new ArrayList<Integer>();
    	for(int i = 0; i < nums1.length; i++) {
    		for(int j = 0; j < nums2.length; j++) {
    			if (nums1[i] == nums2[j]) {
    				if (!al.contains(nums1[i]))
    					al.add(nums1[i]);
    			}
    		}
    	}
    	
    	return al;
    }

	
	//**// 56. Best Time to Buy and Sell Stock II //**//
	public int maxProfit(int[] prices) {
    	int profits = 0;
    	for(int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i-1] && i != 0) {
				profits += (prices[i] - prices[i-1]);
			}
		}
    	return profits;
    }
	
	
	//**// 58. Majority Element //**//
    public int majorityElement(int[] nums) {
    	int so = 0, max = nums.length/2-1;
		for(int i = 0; i < nums.length-1; i++) {
			int count = 0;
			for(int j = i+1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					count++;
				}
			}
			if (count > max) {
				max = count;
				so = nums[i];
			}
		}
		return so;
    }
    
    
    //**// 59. Roman to Integer //**//
    public int romanToInt(String s) {
    	HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		
		hm.put('I', 1);
		hm.put('V', 5);
		hm.put('X', 10);
		hm.put('L', 50);
		hm.put('C', 100);
		hm.put('D', 500);
		hm.put('M', 1000);
		
		int kq = 0;
		for(int i = 0; i < s.length(); i++) {
			if (i != s.length()-1 && hm.get(s.charAt(i)) < hm.get(s.charAt(i+1))) {
				kq += (hm.get(s.charAt(i+1)) - hm.get(s.charAt(i))); 
				i++;
			}
			else kq += hm.get(s.charAt(i));
		}
		return kq;
    }
    
    
    //**// 60. Sum of Left Leaves //**//
//    public int sumOfLeftLeaves(TreeNode root) {
//    	int sum = 0;
//		if (root == null)
//			return 0;
//		if (root.left != null) {
//			if (root.left.left == null && root.left.right == null)
//				sum += root.left.info;
//			else sum += sumOfLeftLeaves(root.left);
//		}
//		sum += sumOfLeftLeaves(root.right);
//		return sum;
//    }
    
    
    //**// 62. Assign Cookies //**//
    public int findContentChildren(int[] g, int[] s) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		for(int x : g)
			al.add(x);
		
		for(int x : s)
			al2.add(x);
		
		int count = 0;
		for(int x : s) {
			if (al.contains(x)) {
				count++;
				al.remove(al.indexOf(x));
				al2.remove(al2.indexOf(x));
			}
		}
		
		if (al2.size() > 0 && al.size() > 0) {
			for(int i = 0; i < al.size(); i++) {
				for(int j = 0; j < al2.size(); j++) {
					if (al2.get(j) > al.get(i)) {
						count++;
						al.remove(i);
						al2.remove(j);
					}
				}
			}
		}
		return count;
    }
    
    
    //**// 63. First Unique Character in a String //**//
    public int firstUniqChar(String s) {
    	int kq = 0;
        for (int i = 0; i < s.length(); i++) {
        	int count = 0;
        	for (int j = 0; j < s.length(); j++) {
        		if (s.charAt(i) ==  s.charAt(j))
        			count++;
        	}
        	if (count == 1) {
        		kq = i;
        		break;
        	}
        }
        return kq;
    }
    
    
    //**// 64. Two Sum II - Input array is sorted //**//
    public int[] twoSum1(int[] numbers, int target) {
        ArrayList<Integer> al = new ArrayList<Integer>();
    	for(int x : numbers) {
    		al.add(x);
    	}
    	int[] result = new int[2];
    	for(int i = 0; i < al.size(); i++) {
    		if (al.contains(target - al.get(i))) {
    			result[0] = i+1;
    			result[1] = al.indexOf(target-al.get(i)) + 1;
    			break;
    		}
    	}
        	
    	return result;
    }
    
    
    //**// 66. Delete Node in a Linked List //**//
//    public void deleteNode(ListNode node) {
//    	ListNode head, tail;
//    	if(!isEmpty()) {
//			if (head == tail && x == head.info)
//				head = tail = null;
//			else if (x == head.info)
//				head = head.next;
//			else {
//				ListNode pred, tmp;
//				for (pred = head, tmp = head.next; 
//						tmp != null && tmp.info != x;
//						pred = pred.next, tmp = tmp.next); // end for loop
//				if(tmp != null) {
//					pred.next = tmp.next;
//					if(tmp == tail)
//						tail = pred;
//				}
//			}
//    	}
//    }
    
    
    //**// 67. Valid Anagram //**//
    public boolean isAnagram(String s, String t) {
    	
        ArrayList<Character> al = new ArrayList<Character>();
        for(char x : s.toCharArray())
        	al.add(x);
        
        char[] x = t.toCharArray();
        for(int i = 0; i < t.length(); i++) {
        	if (al.contains(x[i]))
        		al.remove(al.indexOf(x[i]));
        }
        
        if (al.size() == 0 && !s.contentEquals(t))
        	return true;
        return false;
    }
    
    
    //**// 70. Relative Ranks //**//
    public String[] findRelativeRanks(int[] nums) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int x : nums)
        	al.add(x);
        
        Collections.sort(al);
        
        String[] result = new String[al.size()];
        for(int i = 0; i < al.size(); i++) {
        	if (i == 0)
        		result[0] = "Gold Medal";
        	if (i == 1)
        		result[1] = "Silver Medal";
        	if (i == 2)
        		result[2] = "Bronze Medal";
        	if (i > 2)
        		result[i] = String.valueOf(al.get(i));
        }
        return result;
    }
    
    
    //**// 71. Contains Duplicate //**//
    public boolean containsDuplicate(int[] nums) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int x : nums) {
        	if (al.contains(x))
        		return true;
        	al.add(x);
        }
        return false;
    }
    
    
    //**// 73. Minimum Index Sum of Two Lists //**//
    public String findRestaurant(String[] list1, String[] list2) {
        ArrayList<String> al = new ArrayList<String>();
        for(String x : list1)
        	al.add(x);
        
        ArrayList<String> al1 = new ArrayList<String>();
        for (String x : list2) 
        	al1.add(x);
        
        int min = Integer.MAX_VALUE;
		String result = null;
		for(int i = 0; i < al.size(); i++) {
			int temp = 0;
			if (al1.contains(al.get(i))) {
				temp = i + al1.indexOf(al.get(i));
				if (min > temp) {
					min = temp;
					result = al.get(i);
				}
			}
		}
		
		return result;
    }
    
    
    //**// 74. Sort Array By Parity //**//
    public static ArrayList<Integer> sortArrayByParity(int[] A) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        
        for(int x : A) {
        	if (x % 2 == 0)
        		al.add(x);
        }
        
        for(int x : A) {
        	if (!al.contains(x))
        		al.add(x);
        }
        
        return al;
    }
    
    
    //**// 77. Longest Palindrome //**//
    public int longestPalindrome(String s) {
        ArrayList<Character> al = new ArrayList<Character>();
        for(char x : s.toCharArray()) {
        	if (al.contains(x))
        		al.remove(al.indexOf(x));
        	else al.add(x);
        }
        
        int result = 0;
        if ((s.length() - al.size()) > 1)
        	result = (s.length() - al.size()) + 1;
        
        return result;
    }
    
    
    //**// 78. Find Smallest Letter Greater Than Target //**//
    public char nextGreatestLetter(char[] letters, char target) {        
        for(int i = 0; i < letters.length; i++) {
        	if (((letters[i] - target)) > 1) {
        		return letters[i];
        	}
        }
        return letters[0];
    }
    
    
    //**// 80. Maximum Product of Three Numbers //**//
    public int maximumProduct(int[] nums) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int x : nums)
        	al.add(x);
        
        int count = 0;
        int sum = 1;
        while (count < 3) {
        	int max = al.get(0);
        	for(int x : al) {
        		if (x > max)
        			max = x;
        	}
        	al.remove(al.indexOf(max));
        	sum *= max;
        	count++;
        }
        return sum;
    }
    
    
    //**// 83. Missing Number //**//
    public int missingNumber(int[] nums) {
        ArrayList<Integer> al = new ArrayList<Integer>();
    	for(int x : nums)
        	al.add(x);
    	int result = 0;
    	for(int i = 0; i < nums.length + 1; i++) {
    		if (!al.contains(i)) {
    			result = i;
    			break;
    		}
    	}
    	return result;
    }
    
    
    //**// 84. Student Attendance Record I //**//
    public boolean checkRecord(String s) {
        int na = 0, nl = 0;
        for(int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) == 'A' || s.charAt(i) == 'a')
        		na++;
        	if (s.charAt(i) == 'L' || s.charAt(i) == 'l')
        		nl++;
        }
        
        if (na > 1 || nl > 2)
        	return false;
        return true;
    }
    
    
    //**// 89. Largest Number At Least Twice of Others //**//
    public int dominantIndex(int[] nums) {
        int max = nums[0], index = 0;
        for(int i = 0; i < nums.length; i++) {
        	if (nums[i] > max) {
        		max = nums[i];
        		index = i;
        	}
        }

        int count = 0;
        for(int i = 0; i < nums.length; i++) {
        	if (nums[i] == 0)
        		count++;
        	else if ((max/nums[i]) >= 2)
        		count++;
        }
        
        if (count == nums.length-1)
        	return index;
        return -1;
    }
    
    
    //**// 90. Best Time to Buy and Sell Stock //**//
    public int maxProfit1(int[] prices) {
        int max = 0;
        for(int i = 0; i < prices.length-1; i++) {
        	for(int j = i + 1; j < prices.length; j++) {
        		if ((prices[j] - prices[i]) > max)
        			max = prices[j] - prices[i];
        	}
        }
        
        return max;
    }
    
    
    //**// 91. Longest Continuous Increasing Subsequence //**//
    public int findLengthOfLCIS(int[] nums) {
        int max = 0, count = 1;
    	for(int i = 1; i < nums.length; i++) {
        	if (nums[i] > nums[i-1])
        		count++;
        	else {
        		if (count > max)
        			max = count;
        		count = 1;
        	}
        }
    	return max;
    }
    
    
    //**// 93. Longest Word in Dictionary //**//
    public String longestWord(String[] words) {
        int max = 0;
        String pre = "", prev = words[0], x;
        
        for(int i = 0; i < words.length; i++) {
        	if (prev.compareTo(words[i]) == -1)
        		prev = words[i];
        }
    	for(int i = 0; i < words.length; i++) {
        	int count = 0;
        	for(int j = 0; j < words.length; j++) {
        		if (words[i].contains(words[j]))
        			count++;
        	}
        	if (count >= max) {
        		max = count;    
        		if (words[i].compareTo(prev) == -1 || words[i].compareTo(prev) == 0) {
        			if (pre.length() == words[i].length()) {
        				if (words[i].compareTo(pre) <= -1)
        					pre = words[i];
        			} else {
        				pre = words[i];
        			}
        		}
        	}
        }
    	return pre;
    }
    
    
    //**// 94. Add Strings //**//
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int x = 0,n1,n2;
        String result = "";
        while (i >= 0 || j >= 0 || x > 0) {
        	if (i >= 0)
        		n1 = num1.charAt(i) - '0';
        	else n1 = 0;
        	if (j >= 0)
        		n2 = num2.charAt(j) - '0';
        	else n2 = 0;
        	int s = n1 + n2 + x;
        	result = (s%10) + result;
        	x = s/10;
        	i--;
        	j--;
        }
        return result;
    }
    
    
    //**// 96. Happy Number //**//
    public boolean isHappy(int n) {
        while (n > 9) {
        	int sum = 0;
        	while (n > 0) {
        		int x = n%10;
        		sum += x*x;
        		n =n/10;
        	}
        	n = sum;
        }
        if (n == 1)
        	return true;
        return false;
    }
    
    
    //**// 97. Longest Harmonious Subsequence //**//
    public int findLHS(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
        	int count = 0;
        	for(int j = 0; j < nums.length; j++) {
        		if ((nums[j] - nums[i]) == 1 || nums[j] == nums[i])
        			count++;
        		if (count > max)
        			max = count;
        	}
        }
        return max;
    }
    
    
    //**// 99. Climbing Stairs //**//
    public int climbStairs(int n) {
        if (n <= 2)
        	return n;
        int f1 = 1;
        int f2 = 2;
        int sum = 0;
        for(int i = 3; i <= n; i++) {
        	sum = f1 + f2;
        	f2 = f1;
        	f1 = sum;
        }
        return sum;
    }
    
    
    //**// 101. Power of Two //**//
    public boolean isPowerOfTwo(int n) {
        for(int i = 0; i < n; i++) {
        	if (Math.pow(2, i) == n)
        		return true;
        }
        return false;
    }
    
    
    //**// 102. Power of Three //**//
    public boolean isPowerOfThree(int n) {
    	for(int i = 0; i < n; i++) {
        	if (Math.pow(3, i) == n)
        		return true;
        }
        return false;
    }
    
    
    //**// 104. Reverse Only Letters //**//
    public String reverseOnlyLetters(String S) {
    	String result = "";
    	int j = S.length()-1;
    	for(int i = 0; i < S.length(); i++) {
    		if (Character.isLetter(S.charAt(i))) {
    			if (Character.isLetter(S.charAt(j))) {
    				result += S.charAt(j);
    				j--;
    			}
    			else {
    				j--;
    				result += S.charAt(j);
    				j--;
    				
    			}
    		}
    		else result += S.charAt(i);
    	}
    	return result;
    }
    
    
    //**// 105. License Key Formatting //**//
    public String licenseKeyFormatting(String S, int K) {
    	String result = "";
    	S = S.toUpperCase();
    	int count = 0;
    	for(int i = S.length()-1; i >= 0; i--) {
    		if (count == K) {
    			result = "-" + result;
    			count = 0;
    		}
    		if (Character.isLetter(S.charAt(i)) || Character.isDigit(S.charAt(i))) {
    			result = S.charAt(i) + result;
    			count++;
    		}
    	}
    	return result;
    }
    
    
    //**// 106. Remove Element //**//
    public int removeElement(int[] nums, int val) {
    	int count = 0;
        for(int i = 0; i < nums.length; i++) {
        	if (nums[i] != val)
        		count++;
        }
        return count;
    }
    
    
    //**// 108. Reverse Integer //**//
    public int reverse(int x) {
    	String m = String.valueOf(x);
    	String result = "";
    	if (!Character.isDigit(m.charAt(0)))
    		result = result + m.charAt(0);
    	for(int i = m.length()-1; i >= 0; i--) {
    		if (Character.isDigit(m.charAt(i)))
    			result = result + m.charAt(i);
    	}
    	int k = Integer.parseInt(result);
    	return k;
    }
    
    
    //**// 109. Number of 1 Bits //**//
    public int hammingWeight(int n) {
    	return Integer.bitCount(n);
    }
    
    
    //**// 113. Search Insert Position //**//
    public int searchInsert(int[] nums, int target) {
        if (target < nums[0])
        	return 0;
        if (target > nums[nums.length-1])
        	return nums.length;
    	int index = 0;
        for(int i = 0; i < nums.length; i++) {
        	if (nums[i] < target && nums[i+1] >= target)
        		index = i+1;
        }
    	return index;
    }
    
    
    //**// 115. Find Pivot Index //**//
    public int pivotIndex(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
        	int sumleft = 0, sumright = 0;
        	for(int x = 0; x < i; x++) {
        		sumleft += nums[x];
        	}
        	for(int y = nums.length-1; y > i; y--) {
        		sumright += nums[y];
        	}
        	if (sumleft == sumright)
        		return i;
        }
        return -1;
    }
    
    
    //**// 116. Set Mismatch //**//
    public int[] findErrorNums(int[] nums) {
        int x[] = new int[2];
    	for(int i = 0; i < nums.length-1; i++) {
        	if (nums[i] == nums[i+1]) {
        		x[0] = nums[i];
        		x[1] = i+2;
        	}
        }
    	return x;
    }
    
    
    //**// 117. House Robber //**//
    public int rob(int[] nums) {
        int sum1 = 0, sum2 = 0;
    	for(int i = 0; i < nums.length; i += 2) {
        	sum1 += nums[i];
        }
    	for(int i = 1; i < nums.length; i += 2) {
    		sum2 += nums[i];
    	}
    	if (sum1 > sum2)
    		return sum1;
    	return sum2;
    }
    
    
    //**// 120. Ugly Number //**//
    public boolean isUgly(int num) {
        if (num < 7 && num > 0)
        	return true;
        int x = num;
        int sum = 1;
        while (x > 1) {
        	if (x % 5 == 0) {
        		sum *= 5;
        		x = x / 5;
        	}
        	else if (x % 3 == 0) {
        		sum = sum*3;
        		x = x/3;
        	}
        	else if (x % 2 == 0) {
        		sum *= 2;
        		x = x/2;
        	}
        	else 
        		return false;
        }
        if (sum == num)
        	return true;
        return false;
    }
    
    
    //**// 122. Reverse Vowels of a String //**//
    public String reverseVowels(String s) {
        int j = s.length()-1;
        String m = "";
        for(int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) == 'a' || s.charAt(i) == 'i' || s.charAt(i) == 'u'
        			|| s.charAt(i) == 'e' || s.charAt(i) == 'o') {
        		if (s.charAt(j) == 'a' || s.charAt(j) == 'i' || s.charAt(j) == 'u' ||
        			s.charAt(j) == 'e' || s.charAt(j) == 'o') {
        			m += s.charAt(j);
        			j--;
        		} else {
        			while (s.charAt(j) != 'a' && s.charAt(j) != 'i' && s.charAt(j) != 'u' &&
            			s.charAt(j) != 'e' && s.charAt(j) != 'o') {
        				j--;
        			}
        			m += s.charAt(j);
        			j--;
        		}
        	} else 
        		m += s.charAt(i);
        }
        return m;
    }
    
    
    //**// 123. Power of Four //**//
    public boolean isPowerOfFour(int num) {
    	if (num == 0 || num == 1)
    		return true;
    	for(int i = 2; i < num; i++) {
    		int x = (int) Math.pow(i, 4);
    		if (x == num)
    			return true;
    	}
    	return false;
    }
    
    
    //**// 124. Valid Perfect Square //**//
    public static boolean isPerfectSquare(int num) {
    	if (num == 1)
    		return true;
        for (int i = 2; i < num; i++) {
        	if (i*i == num)
        		return true;
        }
        return false;
    }
    
    
    //**// 126. Repeated Substring Pattern //**//
    public boolean repeatedSubstringPattern(String s) {
    	for(int i = 0; i < s.length()-1; i++) {
    		int count = 0;
    		for(int j = 0; j < s.length()-1; j++) {
    			if (s.substring(i, i+2).equalsIgnoreCase((String) s.subSequence(j, j+2)))
    				count++;
    		}
    		if (count > 1)
    			return true;
    	}
    	return false;
    }
    
    
    //**// 131. Maximum Average Subarray I //**//
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        double avg = 0;
    	for(int i = 0; i <= nums.length-k; i++) {
        	if ((nums[i]+nums[i+1]+nums[i+2]+nums[i+3]) > sum) {
        		sum = nums[i]+nums[i+1]+nums[i+2]+nums[i+3];
        		avg =(double) sum / 4;
        	}
        }
    	return avg;
    }
    
    
    //**// 132. Two Sum //**//
    public int[] twoSum(int[] nums, int target) {
    	int x[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
        	for(int j = 0; j < nums.length; j++) {
        		if ((nums[i] + nums[j]) == target && i != j) {
        			x[0] = i;
        			x[1] = j;
        			return x;
        		}
        	}
        }
        return null;
    }
    
    
    //**// 133. Factorial Trailing Zeroes //**//
    public int trailingZeroes(int n) {
        int sum = 1;
    	for(int i = 1; i <= n; i++) 
        	sum *= i;
    	String m = String.valueOf(sum);
    	int c = 0;
    	for(int i = 0; i < m.length(); i++) {
    		if (m.charAt(i) == '0')
    			c++;
    	}
    	return c;
    }
    
    
    //**// 134. String Compression //**//
    public int compress(char[] chars) {
        int indexAns = 0, index = 0;
        while(index < chars.length){
            char currentChar = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            if(count != 1)
                for(char c : Integer.toString(count).toCharArray()) 
                    chars[indexAns++] = c;
        }
        return indexAns;
    }
    
    
    //**// 135. Number of Segments in a String //**//
    public int countSegments(String s) {
        if (s == null || s.length() == 0) return 0;
        String[] strs = s.split(" ");
        int count = 0;
        for (int i = 0; i < strs.length; i++) {
            if (! strs[i].equals("")) count++;
        }
        return count;
    }
    
    
    //**// 136. Squares of a Sorted Array //**//
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }
    
    
    //**// 137. Count and Say //**//
    public String countAndSay(int n) {
        if (n <= 0)
            return "";

        int count = 1;
        String res = "1";
        while (count < n) {
            char arr[] = res.toCharArray();
            StringBuilder sb = new StringBuilder();
            int i = 0, start, len;
            while(i < arr.length) {
                start = i;
                i++;
                while (i < arr.length && arr[i] == arr[i-1])
                    i++;
                len = (i - start);
                String nxt = len+""+arr[i-1]+"";
                sb.append(nxt);
            }      
            res = sb.toString();
            count++;
        }
        
        return res;
    }
    
    
    //**// 139. Remove Duplicates from Sorted Array //**//
    public static int removeDuplicates(int[] nums) {
        int check = nums[0];
        int count = 1;
        for(int i = 0; i < nums.length; i++) {
        	if (check != nums[i]) {
        		count++;
        		check = nums[i];
        	}
        }
        return count;
    }
    
    
    //**// 142. Palindrome Number //**//
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int y=x,revNumber = 0;
        while(y!=0){
            revNumber = revNumber*10 + y % 10;
            y = y / 10;
        }
        return x==revNumber ? true:false;
    }
    
    
    //**// 144. DI String Match //**//
    public int[] diStringMatch(String S) {
        int n = S.length(), left = 0, right = n;
        int[] res = new int[n + 1];
        for (int i = 0; i < n; ++i)
            res[i] = S.charAt(i) == 'I' ? left++ : right--;
        res[n] = left;
        return res;
    }
    
    
    //**// 145. Delete Columns to Make Sorted //**//
    public int minDeletionSize(String[] A) {
        int count = 0;
        int len = A[0].length();
        
        if(len == 1)
            return 0;
        
        for(int i=0; i<len; i++){
            for(int j=0; j<A.length-1; j++){
                if(A[j].charAt(i)<=A[j+1].charAt(i)){
                    continue;
                }
                count++;
                break;
            }
        }
        return count;
    }
    
    
    //**// 147. Isomorphic Strings //**//
    public boolean isIsomorphic(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
    }
    
    
    //**// 149. Implement Stack using Queues //**//
//    class MyStack {
//        Queue<Integer> q = new LinkedList<Integer>();
//        
//        public void push(int x) {
//            q.add(x);
//            
//            int n = q.size();
//            while (n-- > 1)
//                q.add(q.poll());
//        }
//
//        public void pop() {
//            q.poll();
//        }
//
//        public int top() {
//            return q.peek();
//        }
//
//        public boolean empty() {
//            return q.isEmpty();
//        }
//      }
    
    
    //**// 150. Valid Parentheses //**//
    public boolean isValid(String s) {
        int length;
    
        do {
            length = s.length();
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        } while(length != s.length());
    
        return s.length() == 0;
    }
    
    
    //**// 72. Reverse Linked List //**//
//    public ListNode reverseList(ListNode head) {
//        return reverse(null, head);
//    }
//    
//    private ListNode reverse(ListNode prev, ListNode node) {
//        if (node == null) return prev;
//        ListNode temp = node.next;
//        node.next = prev;
//        return reverse(node, temp);
//    }
    
    
    //**// 87. Reverse String II //**//
    public String reverseStr(String s, int k) {
        StringBuilder ans = new StringBuilder();
        int i = 0;
        int count = 0;
        while (i < s.length()) {
            StringBuilder temp = new StringBuilder();
            int end = i + k;
            while (i < s.length() && i < end) {
                temp.append(s.charAt(i));
                i++;
            }
            
            count++;
            if (count % 2 == 1) {
                ans.append(temp.reverse());
            } else {
                ans.append(temp);
            }
        }
        return ans.toString();
    }
}
