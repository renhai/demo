package me.renhai.demo;

import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.alibaba.fastjson.JSONObject;

import me.renhai.oj.Interval;
import me.renhai.oj.ListNode;
import me.renhai.oj.TreeNode;

public class Demo {

	public static void main(String[] args) throws Exception {
		Demo at = new Demo();
		System.out.println(at.strobogrammaticInRange("50", "100"));

		System.out.println("96".compareTo("50"));
		System.out.println("96".compareTo("100"));

		System.out.println(at.firstUniqChar("leetcode"));

		System.out.println(at.lexicalOrder(346));

		System.out.println(StringUtils.trimToEmpty(" abc"));

		// Document doc = Jsoup.parse(new
		// File("/Users/andy/Downloads/rottentomatoes.com/test.html"), "utf-8");
		// System.out.println(doc.select("script").first().data());

		// IntStream.range(1, 100).map(i -> at.fib2(i)).forEach(i ->
		// System.out.println(i));
		// IntStream.range(1, 50).boxed().collect(Collectors.toMap(i -> i, i ->
		// at.fib2(i))).forEach((k, v) -> System.out.println(k + "-->" + v));

		// String text = FileUtils.readFileToString(new
		// File("/Users/andy/Downloads/rottentomatoes.com/37615e19daf3aed0e89cec5f1668fa3f.json"));
		// JSONObject json = JSONObject.parseObject(text);
		// System.out.println(json.get("link"));
		// System.out.println(json.getJSONObject("script").get("productionCompany"));
		
		String src = "I Can't Breathe";
		src = StringUtils.trimToEmpty(src);
		src = StringUtils.lowerCase(src);
		src = StringUtils.replace(src, "_", " ");
		src = StringUtils.removePattern(src, "[^0-9a-z ]");
		src = StringUtils.replacePattern(src, " +", " ");
		src = StringUtils.replace(src, " ", "_");
		System.out.println(src);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
		String j = "{\"date\":\"2005-04-07T17:00:00-07:00\"}";
		System.out.println(sdf.format(((JSONObject)JSONObject.parse(j)).getDate("date")));
		
		System.out.println(StringUtils.removeStart("sdfasdf/erwer", "/"));
		
		Person p = new Person();
		p.setId(231);
		p.setName("andy");
		System.out.println(ReflectionToStringBuilder.toString(p, ToStringStyle.NO_CLASS_NAME_STYLE));
		System.out.println(ToStringBuilder.reflectionToString(p, ToStringStyle.SHORT_PREFIX_STYLE));
		
		String datestring = "July 9, 1956";
		SimpleDateFormat sd = new SimpleDateFormat("MMMM dd, yyyy");
		System.out.println(sd.parse(datestring));
		
		System.out.println(at.reverseString("hello"));
		
		System.out.println(Integer.toBinaryString(-10));
		System.out.println(at.decemalToBinary(-10));
		
		System.out.println(at.fib(30));
		System.out.println(at.fib2(30));
		System.out.println(at.findSubstringInWraproundString("abaab"));
		
		System.out.println(Character.isDigit('1'));
		
		System.out.println(at.minMeetingRooms(new Interval[] {
				new Interval(7, 10), new Interval(2, 4)
		}));
		
		System.out.println(at.largestRectangleArea(new int[] {4,2}));
		
		System.out.println(at.find132pattern(new int[] {3,5,0,3,4}));
		
		List<int[]> res = at.getSkyline(new int[][] {
			{0,1,2},
			{0,2,3}
		});
		for (int[] is : res) {
			System.out.println(is[0] + "," + is[1]);
		}
		
		System.out.println(at.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
		System.out.println(at.characterReplacement("AABBBBA", 2));
		
		System.out.println(at.multiByOneDigit("678", 5));
	}
	
    private String multiByOneDigit(String num, int digit) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num.length() - 1; i >= 0; i --) {
            int d = num.charAt(i) - '0';
            int product = digit * d + carry;
            sb.insert(0, product % 10);
            carry = product / 10;
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
	
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int counter = 0, start = 0, end = 0, len = 0;
        int[] map = new int[256];
        while (end < s.length()) {
            char c = s.charAt(end ++);
            map[c] ++;
            counter = Math.max(counter, map[c]);
            
            while (end - start - counter > k) {
                c = s.charAt(start ++);
                map[c] --;
            }
            len = Math.max(len, end - start);
        }
        return len;
    }
	
	public int lengthLongestPath(String input) {
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(0); // "dummy" length
		int maxLen = 0;
		String[] lines = input.split("\n");
		for (String line : lines) {
			System.out.println(line);
		}
		for (String s : lines) {
			int lev = s.lastIndexOf("\t") + 1; // number of "\t"
			while (lev + 1 < stack.size())
				stack.pop(); // find parent
			int len = stack.peek() + s.length() - lev + 1; // remove "/t",
															// add"/"
			stack.push(len);
			// check if it is file
			if (s.contains("."))
				maxLen = Math.max(maxLen, len - 1);
		}
		return maxLen;
	}
	
    public ListNode detectCycle(ListNode head) {
        if (head == null) return head;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode begin = head;
                while (begin != slow) {
                    begin = begin.next;
                    slow = slow.next;
                }
                return begin;
            }
        }
        return null;
    }
	
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0) return res;
        List<Point> points = new ArrayList<>();
        for (int[] line : buildings) {
            points.add(new Point(line[0], line[2], true));
            points.add(new Point(line[1], line[2], false));
        }
        Collections.sort(points, new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                if (p1.x != p2.x) {
                    return p1.x - p2.x;
                }
                return (p1.isStart ? -p1.y : p1.y) - (p2.isStart ? -p2.y : p2.y);
                // return p1.y - p2.y;
            }
        });
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        heap.offer(0);
        int prev = 0;
        int curr = 0;
        for (Point p : points) {
            if (p.isStart) {
                heap.offer(p.y);
            } else {
                heap.remove(p.y);
            }
            curr = heap.peek();
            if (prev != curr) {
                res.add(new int[] {p.x, curr});
                prev = curr;
            }
        }
        return res;
    }
    class Point {
        int x;
        int y;
        boolean isStart;
        Point(int x, int y, boolean isStart) {
            this.x = x;
            this.y = y;
            this.isStart = isStart;
        }
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", isStart=" + isStart + "]";
		}
        
        
    }
	
	class Pair {
		int min, max;

		public Pair(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}

	public boolean find132pattern(int[] nums) {
		Stack<Pair> stack = new Stack<>();
		for (int n : nums) {
			if (stack.isEmpty() || n < stack.peek().min)
				stack.push(new Pair(n, n));
			else if (n > stack.peek().min) {
				Pair last = stack.pop();
				if (n < last.max)
					return true;
				else {
					last.max = n;
					while (!stack.isEmpty() && n >= stack.peek().max)
						stack.pop();
					// At this time, n < stack.peek().max (if stack not empty)
					if (!stack.isEmpty() && stack.peek().min < n)
						return true;
					stack.push(last);
				}

			}
		}
		return false;
	}
	
	
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int i = 0;
        while (i < heights.length) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i ++);
            } else {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    max = Math.max(max, i * heights[top]);
                } else {
                    int w = i - stack.peek() - 1;
                    max = Math.max(max, w * heights[top]);
                }
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (stack.isEmpty()) {
                max = Math.max(max, i * heights[top]);
            } else {
                int w = i - stack.peek() - 1;
                max = Math.max(max, w * heights[top]);
            } 
        }
        return max;
    }
	
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> countQueue = new LinkedList<>();
        queue.offer(root);
        countQueue.offer(1);
        int maxCount = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                TreeNode curr = queue.poll();
                int count = countQueue.poll();
                maxCount = Math.max(maxCount, count);
                if (curr.left != null) {
                    queue.offer(curr.left);
                    if (curr.left.val == curr.val + 1) {
                        countQueue.offer(count + 1);
                    } else {
                        countQueue.offer(1);
                    }
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                    if (curr.right.val == curr.val + 1) {
                        countQueue.offer(count + 1);
                    } else {
                        countQueue.offer(1);
                    }
                }
            }
        }
        return maxCount;
    }
	
    public int minMeetingRooms(Interval[] intervals) {
        PriorityQueue<Event> heap = new PriorityQueue<>(new Comparator<Event>() {
            public int compare(Event e1, Event e2) {
                if (e1.time != e2.time) {
                    return e1.time - e2.time;
                }
                return e1.type - e2.type;
            }
        });
        for (Interval interval : intervals) {
            heap.offer(new Event(interval.start, 1));
            heap.offer(new Event(interval.end, -1));
        }
        int maxCount = 0;
        int count = 0;
        while (!heap.isEmpty()) {
            Event event = heap.poll();
            count = event.type == 1 ? count + 1 : count - 1;
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
    
    private class Event {
        int time;
        int type;
        public Event(int time, int type) {
            this.time = time;
            this.type = type;
        }
    }
	
    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0) return 0;
        String dic = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        Set<String> visited = new HashSet<>();
        int[] dp = new int[p.length()];
        for (int i = 0; i < p.length(); i ++) {
            for (int j = 0; j <= i; j ++) {
            	String sub = p.substring(j,i + 1);
                if (!visited.contains(sub) && dic.contains(sub)) {
                    dp[i] ++;
                }
                visited.add(sub);
            }
        }
        int count = 0;
        for (int i : dp) {
            count += i;
        }
        return count;
    }
	
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>> () {
            public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
                return entry2.getValue().compareTo(entry1.getValue());
            }
        });
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            heap.offer(entry);
        }
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            Map.Entry<Character, Integer> entry = heap.poll();
            for (int i = 0; i < entry.getValue(); i ++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
	
	private int fib(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException();
		}
		if (n == 1 || n == 2) {
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}
	
	private int fib2(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException();
		}
		if (n == 1 || n == 2) {
			return n;
		}

		int first = 1;
		int second = 2;
		int res = 0;
		for (int i = 3; i <= n; i++) {
			res = first + second;
			first = second;
			second = res;
		}
		return res;
	}
	
	private String decemalToBinary(int i) {
		StringBuilder sBuilder = new StringBuilder();
		while (i != 0) {
			sBuilder.append(i & 1);
			i >>>= 1;
		}
		return sBuilder.reverse().toString();
	}
	
	public String reverseString(String s) {
		if (s == null || s.length() <= 1) return s;
		return reverseString(s.substring(1)) + s.charAt(0);
	}


	public char findTheDifference(String s, String t) {
		char res = s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			res ^= s.charAt(i);
		}
		for (char c : t.toCharArray()) {
			res ^= c;
		}
		return res;
	}

	public int firstUniqChar(String s) {
		if (s == null || s.length() == 0)
			return -1;
		int[] map = new int[26];
		for (char c : s.toCharArray()) {
			map[c - 'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map[c - 'a'] == 1) {
				return i;
			}
		}
		return -1;
	}

	public List<Integer> lexicalOrder(int n) {
		List<Integer> res = new ArrayList<>();
		if (n < 1)
			return res;
		for (int i = 1; i < 10; i++) {
			helper(n, i, res);
		}
		return res;
	}

	private void helper(int n, int curr, List<Integer> res) {
		if (curr > n)
			return;
		res.add(curr);
		for (int i = 0; i < 10; i++) {
			helper(n, curr * 10 + i, res);
		}
	}

	public int strobogrammaticInRange(String low, String high) {
		List<String> all = new ArrayList<>();
		for (int i = low.length(); i <= high.length(); i++) {
			all.addAll(helper(i, i));
		}
		int count = 0;
		for (String stro : all) {
			if (stro.compareTo(low) >= 0 && stro.compareTo(high) <= 0) {
				count++;
			}
		}
		return count;
	}

	private List<String> helper(int len, int maxLen) {
		if (len == 0) {
			return Arrays.asList("");
		}
		if (len == 1) {
			return Arrays.asList("0", "1", "8");
		}
		List<String> list = helper(len - 2, maxLen);
		List<String> res = new ArrayList<>();
		for (String str : list) {
			if (len != maxLen) {
				res.add("0" + str + "0");
			}
			res.add("1" + str + "1");
			res.add("6" + str + "9");
			res.add("8" + str + "8");
			res.add("9" + str + "6");
		}
		return res;
	}

	void print2D(char[][] sol) {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[0].length; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------------------------");
	}

	void print2D(int[][] sol) {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[0].length; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------------------------");
	}

}
