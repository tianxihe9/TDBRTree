import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.AfterClass;
import org.junit.Test;

public class Testing {

	private static int points = 0;
	////////////////////////// test of primitive cases of removal

	@Test
	public void testRemoveEmptyTree() {
		RedBlackTree<Integer> t = new RedBlackTree<Integer>();
		assertFalse(t.remove(10));
		points += 2;
	}

	@Test
	public void testRemoveJustRoot() {
		RedBlackTree<Integer> t = new RedBlackTree<Integer>();
		assertTrue(t.insert(10));
		assertFalse(t.remove(20));
		assertTrue(t.iterator().hasNext());
		assertEquals(RedBlackTree.Color.BLACK, t.iterator().next().getColor());
		assertTrue(t.remove(10));
		assertFalse(t.iterator().hasNext());
		points += 3;
	}

	@Test
	public void testRemoveSecondElementOrRoot() {
		RedBlackTree<Integer> b = new RedBlackTree<Integer>();
		b.insert(20);
		b.insert(10);
		b.remove(10);
		Iterator<RedBlackTree.BinaryNode> it = b.iterator();
		RedBlackTree.BinaryNode temp = it.next();
		assertEquals(RedBlackTree.Color.BLACK, temp.getColor());
		assertEquals(20, temp.getElement());
		assertFalse(it.hasNext());

		b.insert(10);
		b.remove(20);
		it = b.iterator();
		temp = it.next();
		assertEquals(RedBlackTree.Color.BLACK, temp.getColor());
		assertEquals(10, temp.getElement());
		assertFalse(it.hasNext());
		points += 4;
	}

	@Test
	public void testRemoveNonExistingElementSmallTree() {
		RedBlackTree<Integer> b = new RedBlackTree<Integer>();
		b.insert(20);
		b.insert(10);
		b.remove(5);
		Iterator<RedBlackTree.BinaryNode> it = b.iterator();
		RedBlackTree.BinaryNode temp = it.next();
		assertEquals(RedBlackTree.Color.BLACK, temp.getColor());
		assertEquals(20, temp.getElement());
		temp = it.next();
		assertEquals(RedBlackTree.Color.RED, temp.getColor());
		assertEquals(10, temp.getElement());
		assertFalse(it.hasNext());

		b.remove(15);
		it = b.iterator();
		temp = it.next();
		assertEquals(RedBlackTree.Color.BLACK, temp.getColor());
		assertEquals(20, temp.getElement());
		temp = it.next();
		assertEquals(RedBlackTree.Color.RED, temp.getColor());
		assertEquals(10, temp.getElement());
		assertFalse(it.hasNext());

		b.remove(30);
		it = b.iterator();
		temp = it.next();
		assertEquals(RedBlackTree.Color.BLACK, temp.getColor());
		assertEquals(20, temp.getElement());
		temp = it.next();
		assertEquals(RedBlackTree.Color.RED, temp.getColor());
		assertEquals(10, temp.getElement());
		assertFalse(it.hasNext());
		points += 4;
	}

	@Test
	public void testRemoveSecondElementOrRoot2() {
		RedBlackTree<Integer> b = new RedBlackTree<Integer>();
		b.insert(20);
		b.insert(30);
		b.remove(30);
		Iterator<RedBlackTree.BinaryNode> it = b.iterator();
		RedBlackTree.BinaryNode temp = it.next();
		assertEquals(RedBlackTree.Color.BLACK, temp.getColor());
		assertEquals(20, temp.getElement());
		assertFalse(it.hasNext());

		b.insert(30);
		b.remove(20);
		it = b.iterator();
		temp = it.next();
		assertEquals(RedBlackTree.Color.BLACK, temp.getColor());
		assertEquals(30, temp.getElement());
		assertFalse(it.hasNext());
		points += 4;
	}

	@Test
	public void testRemoveNonExistingElementSmallTree2() {
		RedBlackTree<Integer> b = new RedBlackTree<Integer>();
		b.insert(20);
		b.insert(30);
		b.remove(35);
		Iterator<RedBlackTree.BinaryNode> it = b.iterator();
		RedBlackTree.BinaryNode temp = it.next();
		assertEquals(RedBlackTree.Color.BLACK, temp.getColor());
		assertEquals(20, temp.getElement());
		temp = it.next();
		assertEquals(RedBlackTree.Color.RED, temp.getColor());
		assertEquals(30, temp.getElement());
		assertFalse(it.hasNext());

		b.remove(25);
		it = b.iterator();
		temp = it.next();
		assertEquals(RedBlackTree.Color.BLACK, temp.getColor());
		assertEquals(20, temp.getElement());
		temp = it.next();
		assertEquals(RedBlackTree.Color.RED, temp.getColor());
		assertEquals(30, temp.getElement());
		assertFalse(it.hasNext());

		b.remove(5);
		it = b.iterator();
		temp = it.next();
		assertEquals(RedBlackTree.Color.BLACK, temp.getColor());
		assertEquals(20, temp.getElement());
		temp = it.next();
		assertEquals(RedBlackTree.Color.RED, temp.getColor());
		assertEquals(30, temp.getElement());
		assertFalse(it.hasNext());
		points += 4;
	}

	@Test
	public void testRemoveRootInSmallTree() {
		RedBlackTree<Integer> b = new RedBlackTree<Integer>();
		b.insert(20);
		b.insert(10);
		b.insert(30);
		assertTrue(b.remove(20));

		ArrayList<Object> t = new ArrayList<Object>();
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		ArrayList<Object> s = new ArrayList<Object>();
		s.add(10);
		s.add(30);

		Iterator<RedBlackTree.BinaryNode> it = b.iterator();
		for (int i = 0; i < s.size(); i++) {
			RedBlackTree.BinaryNode temp = it.next();
			assertEquals(t.get(i), temp.getColor());
			assertEquals(s.get(i), temp.getElement());
		}
		points += 4;
	}
	////////////////////////// test of 2A cases of removal

	@Test
	public void testRemove2A1Leaf() {
		// removal from an all black tree
		RedBlackTree<Integer> b = new RedBlackTree<Integer>();
		b.insert(20);
		b.insert(10);
		b.insert(30);
		b.insert(5);
		b.insert(15);
		b.insert(40);
		b.insert(25);
		b.insert(25);
		b.insert(5);
		b.insert(5);
		b.remove(15);

		Iterator<RedBlackTree.BinaryNode> it = b.iterator();
		ArrayList<Object> t = new ArrayList<Object>();
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		ArrayList<Object> s = new ArrayList<Object>();
		s.add(20);
		s.add(10);
		s.add(5);
		s.add(30);
		s.add(25);
		s.add(40);

		for (int i = 0; i < s.size(); i++) {
			RedBlackTree.BinaryNode temp = it.next();
			assertEquals(t.get(i), temp.getColor());
			assertEquals(s.get(i), temp.getElement());
		}
		points += 4;
	}

	@Test
	public void testRemove2A1InternalNode2() {
		// removal from an all black tree
		RedBlackTree<Integer> b = new RedBlackTree<Integer>();
		b.insert(20);
		b.insert(10);
		b.insert(30);
		b.insert(5);
		b.insert(15);
		b.insert(25);
		b.insert(40);
		b.insert(25);
		b.insert(5);
		b.insert(5);
		b.remove(10);
		// System.out.println(b.root.getLeftChild().getLeftChild().getElement());
		Iterator<RedBlackTree.BinaryNode> it = b.iterator();
		// System.out.println("?????");
		ArrayList<Object> t = new ArrayList<Object>();
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);

		ArrayList<Object> s = new ArrayList<Object>();
		s.add(20);
		s.add(5);
		s.add(15);
		s.add(30);
		s.add(25);
		s.add(40);

		for (int i = 0; i < s.size(); i++) {
			RedBlackTree.BinaryNode temp = it.next();
			assertEquals(t.get(i), temp.getColor());
			assertEquals(s.get(i), temp.getElement());
		}
		points += 4;
	}

	@Test
	public void testRemove2A1InternalNode() {
		// removal from an all black tree
		RedBlackTree<Integer> b = new RedBlackTree<Integer>();
		b.insert(20);
		b.insert(10);
		b.insert(30);
		b.insert(5);
		b.insert(15);
		b.insert(25);
		b.insert(40);
		b.insert(2);
		b.insert(7);
		b.insert(7);
		b.insert(12);
		b.insert(17);
		b.insert(17);
		b.insert(17);

		b.insert(22);
		b.insert(27);

		b.insert(35);
		b.insert(47);

		b.insert(47);
		b.insert(27);
		b.insert(27);
		b.insert(27);
		b.remove(10);

		Iterator<RedBlackTree.BinaryNode> it = b.iterator();
		ArrayList<Object> t = new ArrayList<Object>();
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		ArrayList<Object> s = new ArrayList<Object>();
		s.add(20);
		s.add(7);
		s.add(5);
		s.add(2);
		s.add(15);
		s.add(12);
		s.add(17);
		s.add(30);
		s.add(25);
		s.add(22);
		s.add(27);
		s.add(40);
		s.add(35);
		s.add(47);

		for (int i = 0; i < s.size(); i++) {
			RedBlackTree.BinaryNode temp = it.next();
			assertEquals(t.get(i), temp.getColor());
			assertEquals(s.get(i), temp.getElement());
		}
		points += 4;
	}

	@Test
	public void testRemove2A1NonExistingNode() {
		// removal from an all black tree
		RedBlackTree<Integer> b = new RedBlackTree<Integer>();
		b.insert(20);
		b.insert(10);
		b.insert(30);
		b.insert(5);
		b.insert(15);
		b.insert(40);
		b.insert(25);
		b.insert(25);
		b.insert(5);
		b.insert(5);
		b.remove(17);

		Iterator<RedBlackTree.BinaryNode> it = b.iterator();
		ArrayList<Object> t = new ArrayList<Object>();
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		ArrayList<Object> s = new ArrayList<Object>();
		s.add(20);
		s.add(10);
		s.add(5);
		s.add(15);
		s.add(30);
		s.add(25);
		s.add(40);

		for (int i = 0; i < s.size(); i++) {
			RedBlackTree.BinaryNode temp = it.next();
			assertEquals(t.get(i), temp.getColor());
			assertEquals(s.get(i), temp.getElement());
		}
		points += 4;
	}

	@Test
	public void testRemove2A1Root() {
		// removal from an all black tree
		RedBlackTree<Integer> b = new RedBlackTree<Integer>();
		b.insert(20);
		b.insert(10);
		b.insert(30);
		b.insert(5);
		b.insert(15);
		b.insert(40);
		b.insert(25);
		b.insert(25);
		b.insert(5);
		b.insert(5);
		b.remove(20);

		ArrayList<Object> t = new ArrayList<Object>();
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		ArrayList<Object> s = new ArrayList<Object>();
		s.add(15);
		s.add(10);
		s.add(5);
		s.add(30);
		s.add(25);
		s.add(40);

		Iterator<RedBlackTree.BinaryNode> it = b.iterator();
		for (int i = 0; i < s.size(); i++) {
			RedBlackTree.BinaryNode temp = it.next();
			assertEquals(t.get(i), temp.getColor());
			assertEquals(s.get(i), temp.getElement());
		}
		points += 4;
	}

	@Test
	public void testRemove2A3RotationWithLeftChild() {

		RedBlackTree<Integer> b = new RedBlackTree<Integer>();
		b.insert(20);
		b.insert(10);
		b.insert(30);
		b.insert(5);
		b.insert(15);
		b.insert(25);
		b.insert(40);
		b.insert(40);
		b.insert(5);
		b.insert(2);
		b.remove(15);

		Iterator<RedBlackTree.BinaryNode> it = b.iterator();
		ArrayList<Object> t = new ArrayList<Object>();
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		ArrayList<Object> s = new ArrayList<Object>();
		s.add(20);
		s.add(5);
		s.add(2);
		s.add(10);
		s.add(30);
		s.add(25);
		s.add(40);
		for (int i = 0; i < s.size(); i++) {
			RedBlackTree.BinaryNode temp = it.next();
			// System.out.println(i);
			// System.out.println(temp.getElement());
			assertEquals(s.get(i), temp.getElement());
			assertEquals(t.get(i), temp.getColor());
		}
		points += 4;
	}

	@Test
	public void testRemove2A3RotationWithRightChild() {

		RedBlackTree<Integer> b = new RedBlackTree<Integer>();
		b.insert(20);
		b.insert(10);
		b.insert(30);
		b.insert(5);
		b.insert(15);
		b.insert(25);
		b.insert(40);
		b.insert(40);
		b.insert(5);
		b.insert(45);

		b.remove(25);

		Iterator<RedBlackTree.BinaryNode> it = b.iterator();
		ArrayList<Object> t = new ArrayList<Object>();
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		ArrayList<Object> s = new ArrayList<Object>();
		s.add(20);
		s.add(10);
		s.add(5);
		s.add(15);
		s.add(40);
		s.add(30);
		s.add(45);
		for (int i = 0; i < s.size(); i++) {
			RedBlackTree.BinaryNode temp = it.next();
			assertEquals(t.get(i), temp.getColor());
			assertEquals(s.get(i), temp.getElement());
		}
		points += 4;
	}

	@Test
	public void testRemove2A2RotationWithLeftChild() {
		RedBlackTree<Integer> b = new RedBlackTree<Integer>();
		b.insert(20);
		b.insert(10);
		b.insert(30);
		b.insert(5);
		b.insert(15);
		b.insert(25);
		b.insert(40);
		b.insert(40);
		b.insert(5);
		b.insert(12);

		b.remove(5);

		Iterator<RedBlackTree.BinaryNode> it = b.iterator();
		ArrayList<Object> t = new ArrayList<Object>();
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		ArrayList<Object> s = new ArrayList<Object>();
		s.add(20);
		s.add(12);
		s.add(10);
		s.add(15);
		s.add(30);
		s.add(25);
		s.add(40);
		for (int i = 0; i < s.size(); i++) {
			RedBlackTree.BinaryNode temp = it.next();
			assertEquals(t.get(i), temp.getColor());
			assertEquals(s.get(i), temp.getElement());
		}
		points += 4;
	}

	@Test
	public void testRemove2A2RotationWithRightChild() {
		RedBlackTree<Integer> b = new RedBlackTree<Integer>();

		b = new RedBlackTree<Integer>();
		b.insert(20);
		b.insert(10);
		b.insert(30);
		b.insert(5);
		b.insert(15);
		b.insert(25);
		b.insert(40);
		b.insert(40);
		b.insert(5);
		b.insert(27);

		b.remove(40);

		Iterator<RedBlackTree.BinaryNode> it = b.iterator();
		ArrayList<Object> t = new ArrayList<Object>();
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		ArrayList<Object> s = new ArrayList<Object>();
		s.add(20);
		s.add(10);
		s.add(5);
		s.add(15);
		s.add(27);
		s.add(25);
		s.add(30);
		for (int i = 0; i < s.size(); i++) {
			RedBlackTree.BinaryNode temp = it.next();
			assertEquals(t.get(i), temp.getColor());
			assertEquals(s.get(i), temp.getElement());
		}
		points += 4;
	}

	//////////////////////// Test 2B cases of removal
	@Test
	public void testRemove2B1a() {

		// Testing 2B1 with right child
		// the X to which we fall through is a leaf
		RedBlackTree<Integer> b = new RedBlackTree<Integer>();
		b.insert(20);
		b.insert(10);
		b.insert(30);
		b.insert(5);
		b.insert(15);
		b.insert(25);
		b.insert(40);
		b.insert(5);

		b.remove(15);

		Iterator<RedBlackTree.BinaryNode> it = b.iterator();
		ArrayList<Object> t = new ArrayList<Object>();
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.RED);
		ArrayList<Object> s = new ArrayList<Object>();
		s.add(20);
		s.add(10);
		s.add(5);
		s.add(30);
		s.add(25);
		s.add(40);
		for (int i = 0; i < s.size(); i++) {
			RedBlackTree.BinaryNode temp = it.next();
			assertEquals(t.get(i), temp.getColor());
			assertEquals(s.get(i), temp.getElement());
		}
		points += 3;
	}

	@Test
	public void testRemove2B1aa() {

		// Testing 2B1 with right child
		// the X to which we fall through is a leaf
		RedBlackTree<Integer> b = new RedBlackTree<Integer>();
		b.insert(20);
		b.insert(10);
		b.insert(30);
		b.insert(5);
		b.insert(15);
		b.insert(25);
		b.insert(40);
		b.insert(5);
		b.remove(20);
		// System.out.println(b);
		Iterator<RedBlackTree.BinaryNode> it = b.iterator();
		ArrayList<Object> t = new ArrayList<Object>();
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.RED);
		ArrayList<Object> s = new ArrayList<Object>();
		s.add(15);
		s.add(10);
		s.add(5);
		s.add(30);
		s.add(25);
		s.add(40);
		for (int i = 0; i < s.size(); i++) {
			RedBlackTree.BinaryNode temp = it.next();
			assertEquals(t.get(i), temp.getColor());
			assertEquals(s.get(i), temp.getElement());
		}
		points += 3;
	}

	@Test
	public void testRemove2B1b() {
		// Testing 2B1 with right child
		// the X to which we fall through is not a leaf
		RedBlackTree<Integer> b = new RedBlackTree<Integer>();
		b.insert(20);
		b.insert(10);
		b.insert(30);
		b.insert(5);
		b.insert(15);
		b.insert(25);
		b.insert(40);
		b.insert(5);
		b.insert(17);

		b.remove(17);

		Iterator<RedBlackTree.BinaryNode> it = b.iterator();
		ArrayList<Object> t = new ArrayList<Object>();
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.RED);
		ArrayList<Object> s = new ArrayList<Object>();
		s.add(20);
		s.add(10);
		s.add(5);
		s.add(15);
		s.add(30);
		s.add(25);
		s.add(40);
		for (int i = 0; i < s.size(); i++) {
			RedBlackTree.BinaryNode temp = it.next();
			assertEquals(t.get(i), temp.getColor());
			assertEquals(s.get(i), temp.getElement());
		}
		points += 3;
	}

	@Test
	public void testRemove2B1c() {
		// Testing 2B1 with left child
		// the X to which we fall through is a leaf
		RedBlackTree<Integer> b = new RedBlackTree<Integer>();
		b.insert(20);
		b.insert(10);
		b.insert(30);
		b.insert(5);
		b.insert(15);
		b.insert(25);
		b.insert(40);
		b.insert(40);

		b.remove(20);

		Iterator<RedBlackTree.BinaryNode> it = b.iterator();
		ArrayList<Object> t = new ArrayList<Object>();
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		ArrayList<Object> s = new ArrayList<Object>();
		s.add(30);
		s.add(15);
		s.add(10);
		s.add(5);
		s.add(25);
		s.add(40);
		for (int i = 0; i < s.size(); i++) {
			// System.out.println(i);
			RedBlackTree.BinaryNode temp = it.next();
			assertEquals(t.get(i), temp.getColor());
			assertEquals(s.get(i), temp.getElement());
		}
		points += 3;
	}

	@Test
	public void testRemove2B1d() {
		// Testing 2B1 with left child
		// the X to which we fall through is not a leaf
		RedBlackTree<Integer> b = new RedBlackTree<Integer>();
		b.insert(20);
		b.insert(10);
		b.insert(30);
		b.insert(5);
		b.insert(15);
		b.insert(25);
		b.insert(40);
		b.insert(40);
		b.insert(23);

		b.remove(23);

		Iterator<RedBlackTree.BinaryNode> it = b.iterator();
		ArrayList<Object> t = new ArrayList<Object>();
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		ArrayList<Object> s = new ArrayList<Object>();
		s.add(20);
		s.add(10);
		s.add(5);
		s.add(15);
		s.add(30);
		s.add(25);
		s.add(40);
		for (int i = 0; i < s.size(); i++) {
			RedBlackTree.BinaryNode temp = it.next();
			assertEquals(t.get(i), temp.getColor());
			assertEquals(s.get(i), temp.getElement());
		}
		points += 3;
	}

	@Test
	public void testRemove2B2a() {
		// Testing 2B2 with right child
		// removed node is a leaf
		RedBlackTree<Integer> b = new RedBlackTree<Integer>();
		b.insert(20);
		b.insert(10);
		b.insert(30);
		b.insert(5);
		b.insert(15);
		b.insert(40);
		b.insert(5);

		b.remove(40);

		Iterator<RedBlackTree.BinaryNode> it = b.iterator();
		ArrayList<Object> t = new ArrayList<Object>();
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		ArrayList<Object> s = new ArrayList<Object>();
		s.add(10);
		s.add(5);
		s.add(20);
		s.add(15);
		s.add(30);
		for (int i = 0; i < s.size(); i++) {
			RedBlackTree.BinaryNode temp = it.next();
			assertEquals(t.get(i), temp.getColor());
			assertEquals(s.get(i), temp.getElement());
		}
		points += 3;
	}

	@Test
	public void testRemove2B2b() {
		// Testing 2B2 with right child
		// removed node has one child
		RedBlackTree<Integer> b = new RedBlackTree<Integer>();
		b.insert(20);
		b.insert(10);
		b.insert(30);
		b.insert(5);
		b.insert(15);
		b.insert(40);
		b.insert(5);
		b.remove(30);

		Iterator<RedBlackTree.BinaryNode> it = b.iterator();
		ArrayList<Object> t = new ArrayList<Object>();
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		ArrayList<Object> s = new ArrayList<Object>();
		s.add(10);
		s.add(5);
		s.add(20);
		s.add(15);
		s.add(40);
		for (int i = 0; i < s.size(); i++) {
			RedBlackTree.BinaryNode temp = it.next();
			assertEquals(t.get(i), temp.getColor());
			assertEquals(s.get(i), temp.getElement());
		}
		points += 3;
	}

	@Test
	public void testRemove2B2c() {
		// Testing 2B2 with left child
		RedBlackTree<Integer> b = new RedBlackTree<Integer>();
		b.insert(20);
		b.insert(10);
		b.insert(30);
		b.insert(5);
		b.insert(25);
		b.insert(40);
		b.insert(40);
		b.remove(5);

		Iterator<RedBlackTree.BinaryNode> it = b.iterator();
		ArrayList<Object> t = new ArrayList<Object>();
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		ArrayList<Object> s = new ArrayList<Object>();
		s.add(30);
		s.add(20);
		s.add(10);
		s.add(25);
		s.add(40);
		for (int i = 0; i < s.size(); i++) {
			RedBlackTree.BinaryNode temp = it.next();
			assertEquals(t.get(i), temp.getColor());
			assertEquals(s.get(i), temp.getElement());
		}
		points += 3;
	}

	@Test
	public void testRemove2B2d() {
		// Testing 2B2 with left child
		// removed node has one child
		RedBlackTree<Integer> b = new RedBlackTree<Integer>();
		b.insert(20);
		b.insert(10);
		b.insert(30);
		b.insert(5);
		b.insert(25);
		b.insert(40);
		b.insert(40);
		b.remove(10);

		Iterator<RedBlackTree.BinaryNode> it = b.iterator();
		ArrayList<Object> t = new ArrayList<Object>();
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.RED);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		t.add(RedBlackTree.Color.BLACK);
		ArrayList<Object> s = new ArrayList<Object>();
		s.add(30);
		s.add(20);
		s.add(5);
		s.add(25);
		s.add(40);
		for (int i = 0; i < s.size(); i++) {
			RedBlackTree.BinaryNode temp = it.next();
			assertEquals(t.get(i), temp.getColor());
			assertEquals(s.get(i), temp.getElement());
		}
		points += 3;

	}

	public static void nums(int lower, int upper, Iterator<RedBlackTree.BinaryNode> i) {
		if (lower > upper)
			return;
		int mid = (lower + upper) / 2;
		assertEquals(mid, i.next().getElement());
		nums(lower, mid - 1, i);
		nums(mid + 1, upper, i);
	}

	@Test
	public void testingStressRemovalDecrease() {
		RedBlackTree<Integer> b = new RedBlackTree<Integer>();
		// No rotations at all
		int size = 128;// 128
		int v = size / 2;
		int temp;
		while (v > 0) {
			temp = v;
			while (temp < size) {
				b.insert(temp);
				temp += v;
			}
			v = v / 2;
		}
		nums(1, 127, b.iterator()); // 127

		// assertEquals(0, b.getRotationCount());
		// now, let's see whether we will ever have
		// more than one rotation
		int rc;
		int rcc;
		// System.out.println("Testing num rotation: ");
		// b.remove(127);
		// System.out.println(b);
		// b.remove(126);
		// System.out.println(b);
		// System.out.println(b);
		for (int i = 127; i >= 1; i--) { // 127
			// rc = b.getRotationCount();
			// rc = b.getDoubleRotationCount();
			// System.out.println("_____________________" + i);
			// System.out.println(b.remove(i));
			assertTrue(b.remove(i));
			// rcc = b.getRotationCount();
			// rcc = b.getDoubleRotationCount();
			// if ((rcc-rc)>1) {
			// System.out.println(rcc-rc);
			// }
		}
		// System.out.println(b);
		// System.out.println(b.getRotationCount());
		assertEquals(57, b.getRotationCount());
		// System.out.println(b.getRotationCount());
		// System.out.println("End testing");
		points += 6;
	}

	@Test
	public void testingStressRemovalIncrease() {
		RedBlackTree<Integer> b = new RedBlackTree<Integer>();
		// No rotations at all
		int size = 128;
		int v = size / 2;
		int temp;
		while (v > 0) {
			temp = v;
			while (temp < size) {
				b.insert(temp);
				temp += v;
			}
			v = v / 2;
		}

		nums(1, 127, b.iterator());
		for (int i = 1; i < 127; i++) {
			assertTrue(b.remove(i));
		}
		assertEquals(57, b.getRotationCount());
		points += 6;
	}

	@Test
	public void testingLogBehaviorOfRemoval() {
		RedBlackTree<Integer> t = new RedBlackTree<Integer>();
		int nums = 2000000;
		int[] a = new int[nums];
		// populating array
		for (int i = 0; i < nums; i++) {
			a[i] = i;
		}
		int i1;
		int i2;
		int temp;
		// shuffling array
		for (int i = 0; i < nums; i++) {
			i1 = (int) (Math.random() * nums);
			i2 = (int) (Math.random() * nums);
			temp = a[i1];
			a[i1] = a[i2];
			a[i2] = temp;
		}
		for (int i = 0; i < nums; i++)
			t.insert(a[i]);
		assertEquals(nums, t.size());

		for (int i = 0; i < nums; i++) {
			// System.out.println(i);
			t.remove(i);
		}
		assertEquals(0, t.size());
	}

	@AfterClass
	public static void testDoNothing() {
		System.out.println("Points: " + points + "/100");
		// System.out.println("Recolor outside of single rotations.");
	}

}
