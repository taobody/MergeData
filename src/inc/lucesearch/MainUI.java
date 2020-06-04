package inc.lucesearch;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainUI {

	private JFrame frame;
	private JTextField txtEncDir;
	private JTextField txtLidarDir;
	private JTextField txtSepDir;
	private JTextField txtSepPitch;
	private JTextField txtSepOffset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI window = new MainUI();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setTitle("データ結合");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainUI.class.getResource("/res/merge.png")));
		frame.setBounds(100, 100, 694, 223);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Labels
		JLabel lblEncLogPath = new JLabel("エンコーダーログ >>");
		lblEncLogPath.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEncLogPath.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		lblEncLogPath.setBounds(25, 19, 126, 15);
		frame.getContentPane().add(lblEncLogPath);

		JLabel lblLidarLogPath = new JLabel("レーザーログ >>");
		lblLidarLogPath.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLidarLogPath.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		lblLidarLogPath.setBounds(25, 51, 126, 15);
		frame.getContentPane().add(lblLidarLogPath);

		JLabel lblSepTargetPath = new JLabel("分割対象ファイル >>");
		lblSepTargetPath.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSepTargetPath.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		lblSepTargetPath.setBounds(25, 83, 126, 15);
		frame.getContentPane().add(lblSepTargetPath);

		JLabel lblSeparatePitch = new JLabel("分割ピッチ >>");
		lblSeparatePitch.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSeparatePitch.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		lblSeparatePitch.setBounds(25, 115, 126, 15);
		frame.getContentPane().add(lblSeparatePitch);

		JLabel lblSepOffset = new JLabel("オフセット >>");
		lblSepOffset.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSepOffset.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		lblSepOffset.setBounds(25, 147, 126, 15);
		frame.getContentPane().add(lblSepOffset);

		JLabel lblSeparatePitchUnit = new JLabel("cm");
		lblSeparatePitchUnit.setHorizontalAlignment(SwingConstants.LEFT);
		lblSeparatePitchUnit.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		lblSeparatePitchUnit.setBounds(236, 115, 27, 15);
		frame.getContentPane().add(lblSeparatePitchUnit);

		JLabel lblSepPitchOffsetUnit = new JLabel("cm");
		lblSepPitchOffsetUnit.setHorizontalAlignment(SwingConstants.LEFT);
		lblSepPitchOffsetUnit.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		lblSepPitchOffsetUnit.setBounds(236, 147, 27, 15);
		frame.getContentPane().add(lblSepPitchOffsetUnit);

		JLabel lblMergeBaseData = new JLabel("結合基準 >>");
		lblMergeBaseData.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMergeBaseData.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		lblMergeBaseData.setBounds(362, 106, 91, 15);
		frame.getContentPane().add(lblMergeBaseData);

		// Separator
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 71, 610, 2);
		frame.getContentPane().add(separator);

		// TextFields
		txtEncDir = new JTextField();
		txtEncDir.setBounds(163, 17, 394, 19);
		frame.getContentPane().add(txtEncDir);
		txtEncDir.setColumns(10);

		txtLidarDir = new JTextField();
		txtLidarDir.setColumns(10);
		txtLidarDir.setBounds(163, 49, 394, 19);
		frame.getContentPane().add(txtLidarDir);

		txtSepDir = new JTextField();
		txtSepDir.setColumns(10);
		txtSepDir.setBounds(163, 81, 394, 19);
		frame.getContentPane().add(txtSepDir);

		txtSepPitch = new JTextField();
		txtSepPitch.setColumns(10);
		txtSepPitch.setBounds(163, 113, 65, 19);
		frame.getContentPane().add(txtSepPitch);

		txtSepOffset = new JTextField();
		txtSepOffset.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSepOffset.setText("0");
		txtSepOffset.setColumns(10);
		txtSepOffset.setBounds(163, 145, 65, 19);
		frame.getContentPane().add(txtSepOffset);

		// Buttons
		JButton btnEncDir = new JButton("参 照");
		btnEncDir.setBounds(562, 16, 91, 21);
		frame.getContentPane().add(btnEncDir);

		JButton btnLidarDir = new JButton("参 照");
		btnLidarDir.setBounds(562, 48, 91, 21);
		frame.getContentPane().add(btnLidarDir);

		JButton btnSepFileDir = new JButton("参 照");
		btnSepFileDir.setBounds(562, 80, 91, 21);
		frame.getContentPane().add(btnSepFileDir);

		JButton btnClose = new JButton("閉じる");
		btnClose.setBounds(562, 130, 91, 32);
		frame.getContentPane().add(btnClose);

		JButton btnMerge = new JButton("結合開始");
		btnMerge.setBounds(462, 131, 91, 32);
		frame.getContentPane().add(btnMerge);

		JButton btnSeparate = new JButton("分割");
		btnSeparate.setBounds(362, 131, 91, 32);
		frame.getContentPane().add(btnSeparate);

		// RadioButtons
		JRadioButton rbtSetEncBase = new JRadioButton("エンコーダー");
		rbtSetEncBase.setBounds(543, 103, 110, 21);
		frame.getContentPane().add(rbtSetEncBase);

		JRadioButton rbtSetLidarBase = new JRadioButton("レーザー");
		rbtSetLidarBase.setBounds(461, 103, 78, 21);
		frame.getContentPane().add(rbtSetLidarBase);

	}
}
