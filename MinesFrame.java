package mines;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * ɨ���������
*/
public class MinesFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MinesFields ms;		//��ʾɨ����Ϸ���
	private JButton btnStart;	//��ʾ�����¿�ʼ����ť
	
	/**
	 * ���췽��
	 */
	public MinesFrame(){
		setSize(500, 500);	//���ô����С
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);	//���ô�������Ļ����
		setTitle("ɨ��С��Ϸ");		//���ñ���
		setResizable(true);		//������������
		setLayout(new FlowLayout());	//���ò��ֹ�����

		ms = new MinesFields();		//�½����������
		btnStart = new JButton("���¿�ʼ");	//�½���ť

		add(btnStart);	//�Ѱ�ť��ӵ������
		add(ms);		//��ɨ�׳�����ӵ������

		/* ע������¼� */
		addMouseListener(ms.getInnerInstance());
		ms.addMouseListener(ms.getInnerInstance());

		/* ʹ�������ڲ���ķ�ʽ������ť�¼�������Ϸ���¿�ʼ */
		btnStart.addActionListener(new Restart());

		setVisible(true);
	}
	
	/**
	 * �ڲ��࣬����ʵ�ֵ����ť���¿�ʼ��Ϸ�Ĺ���
	 * 
	 */
	private class Restart implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			remove(ms);		//���Ƴ����
			ms = new MinesFields();	//���½�
			add(ms);	//����½���MinesFields����

			/* ע������¼� */
			addMouseListener(ms.getInnerInstance());
			ms.addMouseListener(ms.getInnerInstance());

			setVisible(true);
		}
	}

	public static void main(String[] args) {
		new MinesFrame();
	}

}
