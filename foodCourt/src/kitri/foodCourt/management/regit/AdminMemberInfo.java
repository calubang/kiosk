package kitri.foodCourt.management.regit;

import java.awt.Dimension;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.CardLayout;

@SuppressWarnings("serial")
public class AdminMemberInfo extends JPanel {

	public JTextField searchTextField;

	JPanel memberMenuPanel = new JPanel();
	JPanel tablePanel = new JPanel();

	JPanel infoPanel = new JPanel();
	JLabel searchLabel = new JLabel("\uAC80\uC0C9");

	JButton adminMemberRegisterBtn = new JButton("\uAD00\uB9AC\uC790\uB4F1\uB85D");
	JButton memberRegisterBtn = new JButton("\uD68C\uC6D0\uB4F1\uB85D");
	JButton modifyBtn = new JButton("\uC218\uC815");
	JButton deleteBtn = new JButton("\uC0AD\uC81C");
	JButton adminBtn = new JButton("\uAD00\uB9AC\uC790");
	JButton memberBtn = new JButton("\uD68C\uC6D0");

	AdminTable at = new AdminTable();
	DefaultTableModel model = new DefaultTableModel();
	MemberTable mt = new MemberTable();

	CardLayout cl = new CardLayout(0, 0);

	AdminRegisterControl arc;
	AdminRegister ar;
	MemberRegister mr;
	ModifyAdminRegit maR;
	ModifyRegit mR;
	RemoveMember rm;

	JFrame jfA = new JFrame();
	JDialog jfAD = new JDialog(jfA, "관리자등록");

	JFrame jfM = new JFrame();
	JDialog jfMD = new JDialog(jfM, "회원등록");

	JFrame jfMo = new JFrame();
	JDialog jfMoD = new JDialog();

	JPanel jpaMo;
	CardLayout card = new CardLayout();
	
	public String currentCard = new String();

	boolean check = false;

	/**
	 * Create the panel.
	 */

	public AdminMemberInfo() {

		jpaMo = new JPanel();
		card = new CardLayout();
		maR = new ModifyAdminRegit(at);
		mR = new ModifyRegit(mt);
		jpaMo.setLayout(card);
		jpaMo.add(maR, "adminModi");
		jpaMo.add(mR, "memberModi");

		// jpaMo.setBounds(160, 118, 1012, 634);
		jfMo.getContentPane().add(jpaMo);

		setSize(new Dimension(1007, 722));
		setLayout(null);

		searchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchLabel.setFont(new Font("돋움", Font.PLAIN, 24));
		searchLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		searchLabel.setBounds(398, 0, 110, 60);
		add(searchLabel);

		searchTextField = new JTextField();
		searchTextField.setFont(new Font("돋움돋움", Font.PLAIN, 24));
		searchTextField.setColumns(10);
		searchTextField.setBorder(new LineBorder(Color.BLACK, 1, true));
		searchTextField.setBounds(508, 0, 500, 60);
		add(searchTextField);

		memberMenuPanel
				.setBorder(new CompoundBorder(
						new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uBA54\uB274",
								TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)),
						new EmptyBorder(40, 40, 40, 40)));
		memberMenuPanel.setBounds(799, 128, 209, 594);
		memberMenuPanel.setLayout(new GridLayout(4, 1, 0, 60));
		// adminMemberRegisterBtn.setFont(new Font("돋움", Font.PLAIN, 12));
		memberMenuPanel.add(adminMemberRegisterBtn);
		memberMenuPanel.add(memberRegisterBtn);
		modifyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		memberMenuPanel.add(modifyBtn);
		memberMenuPanel.add(deleteBtn);
		add(memberMenuPanel);

		infoPanel.setBounds(0, 12, 250, 70);
		infoPanel.setLayout(new GridLayout(1, 2, 0, 0));
		adminBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check = false;
				adminBtn.setBorder(new LineBorder(Color.BLACK, 3));
				memberBtn.setBorder(new LineBorder(Color.BLACK, 1));
				cl.show(tablePanel, "AdminTable");
				currentCard = "AdminTable";
				check = false;
			}
		});
		infoPanel.add(adminBtn);
		memberBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check = true;
				adminBtn.setBorder(new LineBorder(Color.BLACK, 1));
				memberBtn.setBorder(new LineBorder(Color.BLACK, 3));
				cl.show(tablePanel, "MemberTable");
				currentCard = "MemberTable";
				check = true;
			}
		});
		infoPanel.add(memberBtn);
		add(infoPanel);

		tablePanel.setBounds(0, 82, 780, 640);
		tablePanel.setLayout(cl);
		tablePanel.add("AdminTable", at);
		tablePanel.add("MemberTable", mt);
		cl.show(tablePanel, "AdminTable");
		currentCard = "AdminTable";
		adminBtn.setBorder(new LineBorder(Color.BLACK, 3));

		add(tablePanel);
		// 테이블 구조 생성

//		add listener
		ar = new AdminRegister();
		mr = new MemberRegister(mt);
		// maR = new ModifyAdminRegit();
		// mR = new ModifyRegit();
		arc = new AdminRegisterControl(this);

		adminMemberRegisterBtn.addActionListener(arc);
		memberRegisterBtn.addActionListener(arc);
		modifyBtn.addActionListener(arc);
		deleteBtn.addActionListener(arc);
		// adminBtn.addActionListener(arc);
		// memberBtn.addActionListener(arc);

		ar.idbtn.addActionListener(arc);
		ar.registerbtn.addActionListener(arc);
		ar.cancelbtn.addActionListener(arc);
		ar.pwtf.addKeyListener(arc);
		ar.passwordtf.addKeyListener(arc);

		mr.idbtn.addActionListener(arc);
		mr.registerbtn.addActionListener(arc);
		mr.cancelbtn.addActionListener(arc);
		mr.pwtf.addKeyListener(arc);
		mr.passwordtf.addKeyListener(arc);

		maR.registerbtn.addActionListener(arc);
		maR.cancelbtn.addActionListener(arc);
		maR.pwtf.addKeyListener(arc);
		maR.passwordtf.addKeyListener(arc);

		mR.registerbtn.addActionListener(arc);
		mR.cancelbtn.addActionListener(arc);
		mR.pwtf.addKeyListener(arc);
		mR.passwordtf.addKeyListener(arc);
		
		//검색
		searchTextField.addActionListener(arc);

	}

}
