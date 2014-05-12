package algorithms.breathfirst;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import datastructure.sets.Bubble;

public class BreathFirst {

	public static void main(String[] args) {

		Bubble b1 = new Bubble();
		Bubble b2 = new Bubble();
		Bubble b3 = new Bubble();
		Bubble b4 = new Bubble();
		b1.directions.add(b2);
		b2.directions.add(b3);
		b3.directions.add(b4);

		Set<Bubble> bubbles = new HashSet<>();
		bubbles.add(b1);
		bubbles.add(b4);
		bubbles.add(b3);
		bubbles.add(b2);

		BFS(bubbles, b1);
	}

	public static void BFS(Set<Bubble> set, Bubble s) {
		Queue<Bubble> queue = new PriorityQueue<Bubble>();
		queue.add(s);
		s.isUsed = true;
		s.props.put("value", 0);

		while (!queue.isEmpty()) {
			Bubble current = queue.poll();
			for (Bubble bubble : current.directions) {
				if (!bubble.isUsed) {
//					bubble.directions.add(current);
					queue.add(bubble);
					bubble.isUsed = true;
					int val = (int) current.props.get("value") + 1;
					System.out.println("gotten val: " + val);
					bubble.props.put("value", val);
				}
			}
		}

		for (Bubble bubble : set) {
			System.out.println("bubble val: "
					+ bubble.props.get("value"));
			System.out.println("conns: " + bubble.directions.size());
		}

	}

}
