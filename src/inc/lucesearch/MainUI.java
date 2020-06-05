package inc.lucesearch;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.prefs.Preferences;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainUI{

	private JFrame mainFrame;
	private JTextField txtEncPath;
	private JTextField txtLidarPath;
	private JTextField txtSepPath;
	private JTextField txtSepPitch;
	private JTextField txtSepOffset;

	private JRadioButton rbtSetEncBase;
	private JRadioButton rbtSetLidarBase;
	private ButtonGroup btnGroup;

	static String result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI window = new MainUI();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setTitle("データ結合");
		mainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainUI.class.getResource("/res/merge.png")));
		mainFrame.setBounds(100, 100, 694, 223);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);

		// Labels
		JLabel lblEncLogPath = new JLabel("エンコーダーログ >>");
		lblEncLogPath.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEncLogPath.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		lblEncLogPath.setBounds(25, 19, 126, 15);
		mainFrame.getContentPane().add(lblEncLogPath);

		JLabel lblLidarLogPath = new JLabel("レーザーログ >>");
		lblLidarLogPath.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLidarLogPath.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		lblLidarLogPath.setBounds(25, 51, 126, 15);
		mainFrame.getContentPane().add(lblLidarLogPath);

		JLabel lblSepTargetPath = new JLabel("分割対象ファイル >>");
		lblSepTargetPath.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSepTargetPath.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		lblSepTargetPath.setBounds(25, 83, 126, 15);
		mainFrame.getContentPane().add(lblSepTargetPath);

		JLabel lblSeparatePitch = new JLabel("分割ピッチ >>");
		lblSeparatePitch.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSeparatePitch.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		lblSeparatePitch.setBounds(25, 115, 126, 15);
		mainFrame.getContentPane().add(lblSeparatePitch);

		JLabel lblSepOffset = new JLabel("オフセット >>");
		lblSepOffset.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSepOffset.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		lblSepOffset.setBounds(25, 147, 126, 15);
		mainFrame.getContentPane().add(lblSepOffset);

		JLabel lblSeparatePitchUnit = new JLabel("cm");
		lblSeparatePitchUnit.setHorizontalAlignment(SwingConstants.LEFT);
		lblSeparatePitchUnit.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		lblSeparatePitchUnit.setBounds(236, 115, 27, 15);
		mainFrame.getContentPane().add(lblSeparatePitchUnit);

		JLabel lblSepPitchOffsetUnit = new JLabel("cm");
		lblSepPitchOffsetUnit.setHorizontalAlignment(SwingConstants.LEFT);
		lblSepPitchOffsetUnit.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		lblSepPitchOffsetUnit.setBounds(236, 147, 27, 15);
		mainFrame.getContentPane().add(lblSepPitchOffsetUnit);

		JLabel lblMergeBaseData = new JLabel("結合基準 >>");
		lblMergeBaseData.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMergeBaseData.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		lblMergeBaseData.setBounds(362, 106, 91, 15);
		mainFrame.getContentPane().add(lblMergeBaseData);

		// Separator
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 71, 610, 2);
		mainFrame.getContentPane().add(separator);

		// TextFields
		txtEncPath = new JTextField();
		txtEncPath.setBounds(163, 17, 394, 19);
		mainFrame.getContentPane().add(txtEncPath);
		txtEncPath.setColumns(10);

		txtLidarPath = new JTextField();
		txtLidarPath.setColumns(10);
		txtLidarPath.setBounds(163, 49, 394, 19);
		mainFrame.getContentPane().add(txtLidarPath);

		txtSepPath = new JTextField();
		txtSepPath.setColumns(10);
		txtSepPath.setBounds(163, 81, 394, 19);
		mainFrame.getContentPane().add(txtSepPath);

		txtSepPitch = new JTextField();
		txtSepPitch.setColumns(10);
		txtSepPitch.setBounds(163, 113, 65, 19);
		mainFrame.getContentPane().add(txtSepPitch);

		txtSepOffset = new JTextField();
		txtSepOffset.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSepOffset.setText("0");
		txtSepOffset.setColumns(10);
		txtSepOffset.setBounds(163, 145, 65, 19);
		mainFrame.getContentPane().add(txtSepOffset);

		// Buttons
		JButton btnEncDir = new JButton("参 照");
		btnEncDir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = openFile().getPath();
				txtEncPath.setText(result);
			}
		});

		btnEncDir.setBounds(562, 16, 91, 21);
		mainFrame.getContentPane().add(btnEncDir);

		JButton btnLidarDir = new JButton("参 照");
		btnLidarDir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = openFile().getPath();
				txtLidarPath.setText(result);
			}
		});
		btnLidarDir.setBounds(562, 48, 91, 21);
		mainFrame.getContentPane().add(btnLidarDir);

		JButton btnSepFileDir = new JButton("参 照");
		btnSepFileDir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = openFile().getPath();
				txtSepPath.setText(result);
			}
		});
		btnSepFileDir.setBounds(562, 80, 91, 21);
		mainFrame.getContentPane().add(btnSepFileDir);

		JButton btnClose = new JButton("閉じる");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.dispose();
			}
		});
		btnClose.setBounds(562, 130, 91, 32);
		mainFrame.getContentPane().add(btnClose);

		JButton btnMerge = new JButton("結合開始");
		btnMerge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("結合を開始します");
				String encLogFilePath = txtEncPath.getText();
				String lidarLogFilePath = txtLidarPath.getText();
				boolean selectedBtn = getSelectedRadioButton();
				result = MakeFile.mergeFiles(encLogFilePath, lidarLogFilePath, selectedBtn);
				JOptionPane.showMessageDialog(null, result);
			}
		});
		btnMerge.setBounds(462, 131, 91, 32);
		mainFrame.getContentPane().add(btnMerge);

		JButton btnSeparate = new JButton("分割");
		btnSeparate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("分割を開始します");
				String targetFile = txtSepPath.getText();
				String sepPitch = txtSepPitch.getText();
				String sepOffset = txtSepOffset.getText();
				result = MakeFile.separateFiles(targetFile, sepPitch, sepOffset);
				JOptionPane.showMessageDialog(null, result);
			}

		});
		btnSeparate.setBounds(362, 131, 91, 32);
		mainFrame.getContentPane().add(btnSeparate);

		// RadioButtons
		rbtSetEncBase = new JRadioButton("エンコーダー");
		rbtSetEncBase.setBounds(543, 103, 110, 21);
		mainFrame.getContentPane().add(rbtSetEncBase);

		rbtSetLidarBase = new JRadioButton("レーザー");
		rbtSetLidarBase.setSelected(true);
		rbtSetLidarBase.setBounds(461, 103, 78, 21);
		mainFrame.getContentPane().add(rbtSetLidarBase);

		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rbtSetEncBase);
		btnGroup.add(rbtSetLidarBase);

	}

	// File Open method
	private File openFile() {
		File filePath = null;
		Preferences prefs = Preferences.userRoot().node(this.getClass().getName());

		JFileChooser jf = new JFileChooser(prefs.get("LAST_USED_FOLDER", new File(".").getAbsolutePath()));
		jf.setFileSelectionMode(JFileChooser.FILES_ONLY);

		int selected = jf.showOpenDialog(null);

		try {
			if (selected == JFileChooser.APPROVE_OPTION) {
				filePath = jf.getSelectedFile();
				prefs.put("LAST_USED_FOLDER", jf.getSelectedFile().getParent());
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		return filePath;
	}

	private boolean getSelectedRadioButton() {
		if (rbtSetEncBase.isSelected()) {
			return true;
		}
		return false;

	}

}
