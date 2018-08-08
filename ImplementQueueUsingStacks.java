/*
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
*/
class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x); 
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(stack1.isEmpty()) {
            return;
        }
        
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        
        stack2.pop();
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        
    }

    // Get the front element.
    public int peek() {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        
        int peek = stack2.peek();
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        
        return peek;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty();
    }
}
