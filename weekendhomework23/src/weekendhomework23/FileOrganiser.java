package weekendhomework23;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FileOrganiser extends JFrame {
	private static final long serialVersionUID = -2047374054587526902L;

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label1 = new JLabel("Browse file to copy: ");
	JButton openBrowseWinow = new JButton("OPEN BROWSE WINOW");
	JLabel label2 = new JLabel("Browse file to delete: ");
	JButton deleteFile = new JButton("DELETE FILE");

	public FileOrganiser() {
		add(panel);
		panel.setLayout(new GridLayout(2, 2));
		panel.add(label1);
		panel.add(openBrowseWinow);
		panel.add(label2);
		panel.add(deleteFile);

		Action listen = new Action();
		openBrowseWinow.addActionListener(listen);
		deleteFile.addActionListener(listen);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 170);
		setLocationRelativeTo(null);
		setTitle("File Organiser");
		setVisible(true);

	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == openBrowseWinow) {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}

				JFileChooser open = new JFileChooser();
				int action = open.showOpenDialog(null);

				if (action == JFileChooser.APPROVE_OPTION) {

					File file = open.getSelectedFile();
					String fileName = file.getName();
					int index = fileName.lastIndexOf(".");
					String exstension = fileName.substring(index + 1, fileName.length());
					Long fileSize = file.getTotalSpace();

					UploadedFile openedFile = new UploadedFile(fileName, exstension, fileSize, file);

					if (openedFile.getFileExtension().equals("png") || openedFile.getFileExtension().equals("jpg")
							|| openedFile.getFileExtension().equals("bmp")
							|| openedFile.getFileExtension().equals("gif")) {

						JFileChooser open1 = new JFileChooser();
						open1.setDialogTitle("Select where you want to copy a file and give it the name:");
						open1.setApproveButtonText("Copy");
						int action1 = open1.showOpenDialog(null);

						if (action1 == JFileChooser.APPROVE_OPTION) {

							try {
								Files.copy(openedFile.getFile().toPath(), open1.getSelectedFile().toPath());
								openBrowseWinow.setEnabled(true);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}

					} else
						if (openedFile.getFileExtension().equals("mp3") || openedFile.getFileExtension().equals("flac")
								|| openedFile.getFileExtension().equals("wmv")) {

						JFileChooser open1 = new JFileChooser();
						open1.setDialogTitle("Select where you want to copy a file and give it the name:");
						open1.setApproveButtonText("Copy");
						int action1 = open1.showOpenDialog(null);

						if (action1 == JFileChooser.APPROVE_OPTION) {

							try {
								Files.copy(openedFile.getFile().toPath(), open1.getSelectedFile().toPath());
								openBrowseWinow.setEnabled(true);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					} else if (openedFile.getFileExtension().equals("doc")
							|| openedFile.getFileExtension().equals("txt")
							|| openedFile.getFileExtension().equals(" xlsx")) {

						JFileChooser open1 = new JFileChooser();
						open1.setDialogTitle("Select where you want to copy a file and give it the name:");
						open1.setApproveButtonText("Copy");
						int action1 = open1.showOpenDialog(null);

						if (action1 == JFileChooser.APPROVE_OPTION) {

							try {
								Files.copy(openedFile.getFile().toPath(), open1.getSelectedFile().toPath());
								openBrowseWinow.setEnabled(true);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}

					} else {
						JFileChooser open1 = new JFileChooser();
						open1.setDialogTitle("Select where you want to copy a file and give it the name:");
						open1.setApproveButtonText("Copy");
						int action1 = open1.showOpenDialog(null);

						if (action1 == JFileChooser.APPROVE_OPTION) {

							try {
								Files.copy(openedFile.getFile().toPath(), open1.getSelectedFile().toPath());
								openBrowseWinow.setEnabled(true);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}

				}

			}
			if (e.getSource() == deleteFile) {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}

				JFileChooser open2 = new JFileChooser();
				int action2 = open2.showOpenDialog(null);
				open2.setDialogTitle("Select file to delete:");
				open2.setApproveButtonText("Delete");

				if (action2 == JFileChooser.APPROVE_OPTION) {

					File file = open2.getSelectedFile();
					String fileName = file.getName();
					int index = fileName.lastIndexOf(".");
					String exstension = fileName.substring(index + 1, fileName.length());
					Long fileSize = file.getTotalSpace();

					UploadedFile openedFile1 = new UploadedFile(fileName, exstension, fileSize, file);

					try {
						Path path = Paths.get(file.getPath());

						Files.delete(path);
						deleteFile.setEnabled(true);
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}
			}

		}

	}

}
