public class Link {
	// This is a link in a list of ints, we will later see how to create a generic-typed link
	int value; 
	Link next;
	
	Link(int v){value = v; next = null;}
	Link(int v, Link n){ value = v; next = n;}	
}


//class Link {
  //  int value;      // the data stored in the node
  //  Link next;      // reference to the next node

  //  Link(int value, Link next) {
  //      this.value = value;
  //      this.next = next;
  //  }
//}

public class Examples {
	public static void main(String[] args) {
		Link head = new Link(5, new Link(2, new Link(-1, null)));

		// lets iterate over the list
		System.out.println("Iterative print:");
		Link curr = head;
		while (curr != null) {
			System.out.print(curr.value + " ");
			curr = curr.next;
		}
		System.out.println();

		// Or we can use recursion:
		System.out.println("Recursive print:");
		printListHeadToTail(head);
		System.out.println();

		/*
		 * Another way to create the same list 
		 * Link head = new Link(5, null); 
		 * Link l1 = new Link(2, null); 
		 * Link l2 = new Link(-1, null); 
		 * head.next = l1; l1.next = l2;
		 */

	}

	public static void printListHeadToTail(Link h) {
		if (h != null) {
			System.out.print(h.value + " ");
			printListHeadToTail(h.next);
		}
		// the base case is hiding, can you tell what it is?
	}
	
}