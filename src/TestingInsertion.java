import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.AfterClass;
import org.junit.Test;

public class TestingInsertion {

	private static int points = 0;

	////////////////////////// TESTING INSERTION

	/////////// BASIC TESTS

	@Test
	public void testInsertEmptyTree() {
		RedBlackTree<Integer> t = new RedBlackTree<Integer>();
		assertTrue(t.insert(5));

		Iterator<RedBlackTree.BinaryNode> i = t.iterator();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(5);
		ArrayList<RedBlackTree.Color> cols = new ArrayList<RedBlackTree.Color>();
		cols.add(RedBlackTree.Color.BLACK);
		for (int k = 0; k < nums.size(); k++) {
			RedBlackTree.BinaryNode temp = i.next();
			assertEquals(nums.get(k), temp.getElement());
			assertEquals(cols.get(k), temp.getColor());
		}
		assertFalse(i.hasNext());
		assertEquals(0, t.getRotationCount());
		points += 5;
	}

	@Test
	public void testInsertSecondThirdElement() {
		// no rotations necessary
		RedBlackTree<Integer> t = new RedBlackTree<Integer>();
		assertTrue(t.insert(10));
		assertTrue(t.insert(20));
		assertTrue(t.insert(5));

		Iterator<RedBlackTree.BinaryNode> i = t.iterator();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(10);
		nums.add(5);
		nums.add(20);
		ArrayList<RedBlackTree.Color> cols = new ArrayList<RedBlackTree.Color>();
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.RED);
		cols.add(RedBlackTree.Color.RED);
		RedBlackTree.BinaryNode temp;
		for (int k = 0; k < nums.size(); k++) {
			temp = i.next();
			assertEquals(nums.get(k), temp.getElement());
			assertEquals(cols.get(k), temp.getColor());
		}
		assertFalse(i.hasNext());
		assertEquals(0, t.getRotationCount());
		points += 5;

		// testing color flip
		assertFalse(t.insert(10));
		i = t.iterator();
		for (int k = 0; k < nums.size(); k++) {
			temp = i.next();
			assertEquals(nums.get(k), temp.getElement());
			assertEquals(RedBlackTree.Color.BLACK, temp.getColor());
		}
		assertFalse(i.hasNext());
		assertEquals(0, t.getRotationCount());
		points += 5;
	}

	///////////// SINGLE ROTATIONS ON RIGHT CHILD

	@Test
	public void testSingleRotationOnRightChild() {
		RedBlackTree<Integer> t = new RedBlackTree<Integer>();
		t.insert(2);

		t.insert(1);

		t.insert(3);

		t.insert(4);
		// System.out.println("___________________________");
		t.insert(5);
		// System.out.println("___________________________");
		Iterator<RedBlackTree.BinaryNode> i = t.iterator();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(2);
		nums.add(1);
		nums.add(4);
		nums.add(3);
		nums.add(5);
		// System.out.println("rotation:" + t.getRotationCount());
		ArrayList<RedBlackTree.Color> cols = new ArrayList<RedBlackTree.Color>();
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.RED);
		cols.add(RedBlackTree.Color.RED);
		RedBlackTree.BinaryNode temp;
		for (int k = 0; k < nums.size(); k++) {
			temp = i.next();
			// System.out.println(temp.getElement());
			// System.out.println(temp.getColor());
			assertEquals(nums.get(k), temp.getElement());
			assertEquals(cols.get(k), temp.getColor());
		}
		assertFalse(i.hasNext());
		assertEquals(1, t.getRotationCount());
		points += 5;
	}

	@Test
	public void testSingleRotationOnRightChildInvolvingRoot() {
		RedBlackTree<Integer> t = new RedBlackTree<Integer>();
		t.insert(1);
		t.insert(2);
		t.insert(3);

		Iterator<RedBlackTree.BinaryNode> i = t.iterator();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(2);
		nums.add(1);
		nums.add(3);
		ArrayList<RedBlackTree.Color> cols = new ArrayList<RedBlackTree.Color>();
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.RED);
		cols.add(RedBlackTree.Color.RED);
		RedBlackTree.BinaryNode temp;
		for (int k = 0; k < nums.size(); k++) {
			temp = i.next();
			assertEquals(nums.get(k), temp.getElement());
			assertEquals(cols.get(k), temp.getColor());
		}
		assertFalse(i.hasNext());
		assertEquals(1, t.getRotationCount());
		points += 5;
	}

	@Test
	public void testSingleRotationOnRightChildInvolvingRootCausedByColorFlip() {
		RedBlackTree<Integer> t = new RedBlackTree<Integer>();
		for (int k = 1; k <= 7; k++) {
			// System.out.println("k:" + k);
			assertTrue(t.insert(k));
			// System.out.println("___________________________________");
		}
		// System.out.println("?");
		assertFalse(t.insert(7));

		Iterator<RedBlackTree.BinaryNode> i = t.iterator();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(4);
		nums.add(2);
		nums.add(1);
		nums.add(3);
		nums.add(6);
		nums.add(5);
		nums.add(7);
		ArrayList<RedBlackTree.Color> cols = new ArrayList<RedBlackTree.Color>();
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.RED);
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.RED);
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.BLACK);
		RedBlackTree.BinaryNode temp;
		for (int k = 0; k < nums.size(); k++) {
			temp = i.next();
			assertEquals(nums.get(k), temp.getElement());
			assertEquals(cols.get(k), temp.getColor());
		}
		assertFalse(i.hasNext());
		assertEquals(4, t.getRotationCount());
		// System.out.println(t);
		points += 5;
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
	public void testingStressWithNoRotations() {
		RedBlackTree<Integer> t = new RedBlackTree<Integer>();

		// No rotations at all
		int size = 128;
		int v = size / 2;
		int temp;
		while (v > 0) {
			temp = v;
			while (temp < size) {
				t.insert(temp);
				temp += v;
			}
			v = v / 2;
		}
		nums(1, 127, t.iterator());
		assertEquals(0, t.getRotationCount());
		points += 5;
	}

	@Test
	public void testingStressWithOnlySingleRotationOnRightChild() {
		RedBlackTree<Integer> t = new RedBlackTree<Integer>();
		for (int i = 1; i < 128; i++)
			t.insert(i);// 128
		// for (int i = 1; i < 16; i++) t.insert(i);
		// System.out.println(t.height());
		// System.out.println(t.root.getElement());
		// int rc = t.getRotationCount();
		// t.remove(12);
		// int rcc = t.getRotationCount();
		// System.out.println(rcc-rc);
		// System.out.println(t.height());

		// System.out.println(t.getRotationCount());
		// System.out.println(t.height());
		assertEquals(11, t.height());
		t.insert(127);

		// System.out.println(t);
		// System.out.println(t.height());
		assertEquals(10, t.height());
		t.insert(127);
		// System.out.println(t);
		// System.out.println(t.height());
		assertEquals(9, t.height());
		t.insert(127);
		// System.out.println(t);
		// System.out.println(t.height());
		assertEquals(8, t.height());
		t.insert(127);
		// System.out.println(t);
		// System.out.println(t.height());
		assertEquals(7, t.height());
		t.insert(127);
		// System.out.println(t);
		// System.out.println(t.height());
		assertEquals(6, t.height());
		nums(1, 127, t.iterator());
		assertEquals(120, t.getRotationCount());
		points += 5;
	}

	///////////////// SINGLE ROTATIONS ON LEFT CHILD

	@Test
	public void testSingleRotationOnLeftChild() {
		RedBlackTree<Integer> t = new RedBlackTree<Integer>();
		t.insert(4);
		t.insert(5);
		t.insert(3);
		t.insert(2);
		t.insert(1);

		Iterator<RedBlackTree.BinaryNode> i = t.iterator();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(4);
		nums.add(2);
		nums.add(1);
		nums.add(3);
		nums.add(5);
		ArrayList<RedBlackTree.Color> cols = new ArrayList<RedBlackTree.Color>();
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.RED);
		cols.add(RedBlackTree.Color.RED);
		cols.add(RedBlackTree.Color.BLACK);

		RedBlackTree.BinaryNode temp;
		for (int k = 0; k < nums.size(); k++) {
			temp = i.next();
			assertEquals(nums.get(k), temp.getElement());
			assertEquals(cols.get(k), temp.getColor());
		}
		assertFalse(i.hasNext());
		assertEquals(1, t.getRotationCount());
		points += 5;
	}

	@Test
	public void testSingleRotationOnLeftChildInvolvingRoot() {
		RedBlackTree<Integer> t = new RedBlackTree<Integer>();
		t.insert(3);
		t.insert(2);
		t.insert(1);

		Iterator<RedBlackTree.BinaryNode> i = t.iterator();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(2);
		nums.add(1);
		nums.add(3);
		ArrayList<RedBlackTree.Color> cols = new ArrayList<RedBlackTree.Color>();
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.RED);
		cols.add(RedBlackTree.Color.RED);
		RedBlackTree.BinaryNode temp;
		for (int k = 0; k < nums.size(); k++) {
			temp = i.next();
			assertEquals(nums.get(k), temp.getElement());
			assertEquals(cols.get(k), temp.getColor());
		}
		assertFalse(i.hasNext());
		assertEquals(1, t.getRotationCount());
		points += 5;
	}

	@Test
	public void testSingleRotationOnLeftChildInvolvingRootCausedByColorFlip() {
		RedBlackTree<Integer> t = new RedBlackTree<Integer>();
		for (int k = 7; k >= 1; k--) {
			assertTrue(t.insert(k));
		}
		assertFalse(t.insert(1));

		Iterator<RedBlackTree.BinaryNode> i = t.iterator();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(4);
		nums.add(2);
		nums.add(1);
		nums.add(3);
		nums.add(6);
		nums.add(5);
		nums.add(7);
		ArrayList<RedBlackTree.Color> cols = new ArrayList<RedBlackTree.Color>();
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.RED);
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.RED);
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.BLACK);
		RedBlackTree.BinaryNode temp;
		for (int k = 0; k < nums.size(); k++) {
			temp = i.next();
			assertEquals(nums.get(k), temp.getElement());
			assertEquals(cols.get(k), temp.getColor());
		}
		assertFalse(i.hasNext());
		assertEquals(4, t.getRotationCount());
		points += 5;
	}

	@Test
	public void testingStressWithOnlySingleRotationOnLeftChild() {
		RedBlackTree<Integer> t = new RedBlackTree<Integer>();
		for (int i = 127; i >= 1; i--)
			t.insert(i);// 127
		// System.out.println(t.root.getElement());
		assertEquals(11, t.height());
		t.insert(1);
		assertEquals(10, t.height());
		t.insert(1);
		assertEquals(9, t.height());
		t.insert(1);
		assertEquals(8, t.height());
		t.insert(1);
		assertEquals(7, t.height());
		t.insert(1);
		assertEquals(6, t.height());
		nums(1, 127, t.iterator());
		assertEquals(120, t.getRotationCount());
		points += 5;
	}

	///////////////// DOUBLE ROTATIONS ON RIGHT CHILD
	@Test
	public void testDoubleRotationOnRightChild() {
		RedBlackTree<Integer> t = new RedBlackTree<Integer>();
		// System.out.println("________________________________");
		t.insert(2);
		// System.out.println("________________________________");
		// System.out.println(t.toString());
		t.insert(1);
		// System.out.println("________________________________");
		// System.out.println(t.toString());
		t.insert(5);
		// System.out.println(t.toString());
		// System.out.println("________________________________");
		t.insert(3);
		// System.out.println(t.toString());
		// System.out.println("________________________________");
		t.insert(4);
		// System.out.println("heeeeerrrrreeeee");
		// System.out.println(t.toString());

		Iterator<RedBlackTree.BinaryNode> i = t.iterator();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(2);
		nums.add(1);
		nums.add(4);
		nums.add(3);
		nums.add(5);
		ArrayList<RedBlackTree.Color> cols = new ArrayList<RedBlackTree.Color>();
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.RED);
		cols.add(RedBlackTree.Color.RED);

		RedBlackTree.BinaryNode temp;
		for (int k = 0; k < nums.size(); k++) {
			temp = i.next();
			// System.out.println(temp.getElement());
			assertEquals(nums.get(k), temp.getElement());
			assertEquals(cols.get(k), temp.getColor());
		}
		assertFalse(i.hasNext());
		assertEquals(2, t.getRotationCount());
		points += 5;
	}

	@Test
	public void testDoubleRotationOnRightChildInvolvingRoot() {
		RedBlackTree<Integer> t = new RedBlackTree<Integer>();
		t.insert(1);
		t.insert(3);
		t.insert(2);

		Iterator<RedBlackTree.BinaryNode> i = t.iterator();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(2);
		nums.add(1);
		nums.add(3);
		ArrayList<RedBlackTree.Color> cols = new ArrayList<RedBlackTree.Color>();
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.RED);
		cols.add(RedBlackTree.Color.RED);
		RedBlackTree.BinaryNode temp;
		for (int k = 0; k < nums.size(); k++) {
			temp = i.next();
			assertEquals(nums.get(k), temp.getElement());
			assertEquals(cols.get(k), temp.getColor());
		}
		assertFalse(i.hasNext());
		assertEquals(2, t.getRotationCount());
		points += 5;
	}

	@Test
	public void testDoubleRotationOnRightChildInvolvingRootCausedByColorFlip() {
		RedBlackTree<Integer> t = new RedBlackTree<Integer>();
		assertTrue(t.insert(1));
		// System.out.println(t.toString());
		assertTrue(t.insert(3));
		// System.out.println(t.toString());
		assertTrue(t.insert(2));
		// System.out.println(t.toString());
		assertTrue(t.insert(7));
		assertTrue(t.insert(6));
		assertTrue(t.insert(5));
		assertTrue(t.insert(4));
		// System.out.println("__________________________________");
		assertFalse(t.insert(5));

		Iterator<RedBlackTree.BinaryNode> i = t.iterator();
		// System.out.println(i.next().getElement());
		// System.out.println(i.next().getElement());
		// System.out.println(i.next().getElement());
		// System.out.println(i.next().getElement());
		// System.out.println(i.next().getElement());
		// System.out.println(i.next().getElement());
		// System.out.println(i.next().getElement());
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(4);
		nums.add(2);
		nums.add(1);
		nums.add(3);
		nums.add(6);
		nums.add(5);
		nums.add(7);
		ArrayList<RedBlackTree.Color> cols = new ArrayList<RedBlackTree.Color>();
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.RED);
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.RED);
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.BLACK);
		RedBlackTree.BinaryNode temp;
		for (int k = 0; k < nums.size(); k++) {
			temp = i.next();
			assertEquals(nums.get(k), temp.getElement());
			assertEquals(cols.get(k), temp.getColor());
		}
		assertFalse(i.hasNext());
		assertEquals(8, t.getRotationCount());
		points += 5;
	}

	/////////////// DOUBLE ROTATIONS ON LEFT CHILD
	@Test
	public void testDoubleRotationOnLeftChild() {
		RedBlackTree<Integer> t = new RedBlackTree<Integer>();
		t.insert(4);
		t.insert(5);
		t.insert(3);
		t.insert(1);
		t.insert(2);

		Iterator<RedBlackTree.BinaryNode> i = t.iterator();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(4);
		nums.add(2);
		nums.add(1);
		nums.add(3);
		nums.add(5);
		ArrayList<RedBlackTree.Color> cols = new ArrayList<RedBlackTree.Color>();
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.RED);
		cols.add(RedBlackTree.Color.RED);
		cols.add(RedBlackTree.Color.BLACK);

		RedBlackTree.BinaryNode temp;
		for (int k = 0; k < nums.size(); k++) {
			temp = i.next();
			assertEquals(nums.get(k), temp.getElement());
			assertEquals(cols.get(k), temp.getColor());
		}
		assertFalse(i.hasNext());
		assertEquals(2, t.getRotationCount());
		points += 5;
	}

	@Test
	public void testDoubleRotationOnLeftChildInvolvingRoot() {
		RedBlackTree<Integer> t = new RedBlackTree<Integer>();
		t.insert(3);
		t.insert(1);
		t.insert(2);

		Iterator<RedBlackTree.BinaryNode> i = t.iterator();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(2);
		nums.add(1);
		nums.add(3);
		ArrayList<RedBlackTree.Color> cols = new ArrayList<RedBlackTree.Color>();
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.RED);
		cols.add(RedBlackTree.Color.RED);
		RedBlackTree.BinaryNode temp;
		for (int k = 0; k < nums.size(); k++) {
			temp = i.next();
			assertEquals(nums.get(k), temp.getElement());
			assertEquals(cols.get(k), temp.getColor());
		}
		assertFalse(i.hasNext());
		assertEquals(2, t.getRotationCount());
		points += 5;
	}

	@Test
	public void testDoubleRotationOnLeftChildInvolvingRootCausedByColorFlip() {
		RedBlackTree<Integer> t = new RedBlackTree<Integer>();
		assertTrue(t.insert(7));
		assertTrue(t.insert(5));
		assertTrue(t.insert(6));
		assertTrue(t.insert(1));
		assertTrue(t.insert(2));
		assertTrue(t.insert(3));
		assertTrue(t.insert(4));
		assertFalse(t.insert(3));

		Iterator<RedBlackTree.BinaryNode> i = t.iterator();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(4);
		nums.add(2);
		nums.add(1);
		nums.add(3);
		nums.add(6);
		nums.add(5);
		nums.add(7);
		ArrayList<RedBlackTree.Color> cols = new ArrayList<RedBlackTree.Color>();
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.RED);
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.RED);
		cols.add(RedBlackTree.Color.BLACK);
		cols.add(RedBlackTree.Color.BLACK);
		RedBlackTree.BinaryNode temp;
		for (int k = 0; k < nums.size(); k++) {
			temp = i.next();
			assertEquals(nums.get(k), temp.getElement());
			assertEquals(cols.get(k), temp.getColor());
		}
		assertFalse(i.hasNext());
		assertEquals(8, t.getRotationCount());
		points += 5;
	}

	@Test
	public void testingStressWithOnlyDoubleRotations() {
		RedBlackTree<Integer> t = new RedBlackTree<Integer>();
		int maxx = 64;// 64
		int num = maxx / 2;
		int offset = num;
		int start = offset;
		t.insert(0);
		while (num > 0) {
			while (start < maxx) {
				t.insert(start * 2);
				t.insert(start * 2 - 1);
				start += offset;
			}
			offset = num;
			num = num / 2;
			start = num;
		}
		// System.out.println(t.root.getElement());
		nums(0, 126, t.iterator());
		assertEquals(126, t.getRotationCount());
		points += 10;
	}

	@Test
	public void testingLogBehaviorOfInsert() {
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
	}

	@AfterClass
	public static void testDoNothing() {
		System.out.println("Points: " + points);
		// System.out.println("Recolor outside of single rotations.");
	}

}
