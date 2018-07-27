/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
*/

class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    
    public MyStack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    
    // Push element x onto stack.
    public void push(int x) {
        
        q2.offer(x);
        while(q1.peek() != null) {
            q2.offer(q1.poll());
        }
        
        Queue<Integer> temp = q2;
        q2 = q1;
        q1 = temp;
    }

    // Removes the element on top of the stack.
    public void pop() {
        q1.poll();
    }

    // Get the top element.
    public int top() {
        return q1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if(q1.peek() == null) {
            return true;
        }
        return false;
    }
}
