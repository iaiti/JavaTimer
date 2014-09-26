package TimerTask;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ChooserFile extends JFrame implements ActionListener {
	JTextField labfilepath;
	JTextField time;
	JPanel panel;
	JButton btn;
	JButton btn2;

	public ChooserFile() {
		setBounds(500, 300, 300, 300);
		labfilepath = new JTextField(20);
		time = new JTextField(20);
		btn = new JButton("选择文件");
		btn2 = new JButton("确定");
		btn.addActionListener(this);

		panel = new JPanel();
		panel.add(new Label("运行间隔时间(单位：秒)"));
		panel.add(time);

		panel.add(new Label("请选择程序"));
		panel.add(labfilepath);
		panel.add(btn);
		panel.add(btn2);
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = "";
				str += time.getText();
				System.out.println(str);
				String str2 = "";
				str2 += labfilepath.getText();
				System.out.println(str2);
				TimerClose tc = new TimerClose(Long.parseLong(str) * 1000, str2);
				System.out.println(tc.getLongtime());
				tc.run();
				// tc.run();
			}
		});
		getContentPane().add(panel);
		setTitle("定时执行器");
		setSize(400, 200);
		setVisible(true);
	}

	public static void main(String args[]) {
		new ChooserFile();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		open();
	}

	public void open() {
		JFileChooser chooser = new JFileChooser();
		chooser.setMultiSelectionEnabled(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("EXE",
				"exe", "txt", "lnk");
		chooser.setFileFilter(filter);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setDialogTitle("Seletct exe File");
		int result = chooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			String filename = file.getName();
			File file1 = chooser.getCurrentDirectory();
			String filepath = file1.getAbsolutePath();
			labfilepath.setText(filepath + "\\" + filename);// 将文件路径设到JTextField

			// System.out.println(filepath+"\\"+filename);
		}
	}
}
