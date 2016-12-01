package com.rgc.trainging.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class TestFrame {

	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame("RGC test");
				frame.setLayout(new FlowLayout());
				JLabel label = new JLabel("???");
				frame.add(label);
				final JButton button = new JButton("press");
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						label.setText(Boolean.toString(SwingUtilities.isEventDispatchThread()));
					}
				});
				JTextField textField = new JTextField();
				frame.add(button);
				frame.pack();
				frame.setVisible(true);
			}
		});
		new SwingWorker<String, Long>() {

			@Override
			protected String doInBackground() throws Exception {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			protected void done() {
				// TODO Auto-generated method stub
				super.done();
			}

			@Override
			protected void process(List<Long> chunks) {
				// TODO Auto-generated method stub
				super.process(chunks);
			}

		};
	}

}
