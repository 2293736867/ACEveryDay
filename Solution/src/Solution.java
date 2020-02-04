import java.util.Scanner;

class ListNode
{
    int val;
    ListNode next;
    ListNode(int x)
    {
        val = x;
    }
    void add(int x)
    {
        ListNode t = this;
        while(t.next != null)
            t = t.next;
        t.next = new ListNode(x);
    }
    void print()
    {
        ListNode t = this;
        while(t != null)
        {
            System.out.print(t.val);
            if((t = t.next) != null)
                System.out.print("->");
        }
        System.out.println();
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        ListNode x = new ListNode(4);
//        x.add(4);
//        x.add(9);
//        x.add(88);
//        x.add(133);
//        x.add(1999);
//        x.add(99999);
//        ListNode result = new Solution().reverseKGroup(x,scanner.nextInt());
//        result.print();
        int max = Integer.MIN_VALUE;
        System.out.println("max is "+max);
        max = -max;
        System.out.println("-max is "+max);
        while (true)
        {
            System.out.println(new Solution().divide(scanner.nextInt(),scanner.nextInt()));
        }
    }

    public int divide(int dividend,int divisor)
    {
        boolean negative = true;
        if((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            negative = false;
        dividend = dividend > 0 ? dividend : -dividend;
        divisor = divisor > 0 ? divisor : -divisor;
        int result = 0;
        while(dividend >= divisor)
        {
            dividend -= divisor;
            ++result;
        }
        return negative ? -result : result;
    }

    public ListNode reverseKGroup(ListNode head,int k)
    {
        if(head == null || k <= 1)
            return head;
        ListNode dummy = new ListNode(0);
        ListNode t = dummy;
        while(true)
        {
            ListNode dummy2 = new ListNode(0);
            ListNode tt;
            ListNode temp = head;
            int i=0;
            for(;i<k && head != null;++i)
            {
                tt = new ListNode(head.val);
                tt.next = dummy2.next;
                dummy2.next = tt;
                head = head.next;
            }
            if(i == k)
            {
                for(i=0;i<k;++i)
                {
                    t.next = dummy2.next;
                    t = t.next;
                    dummy2 = dummy2.next;
                }
            }
            else if(head == null)
            {
                t.next = temp;
                break;
            }
        }
        return dummy.next;
    }
}

