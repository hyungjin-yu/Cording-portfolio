package admin;

import java.sql.Connection;
import java.util.List;

import apply.ApplyDTO;

public interface Admin {
	public Connection getConnection();		// db�� ����
	public void close();					// db�� ���� ����
	public int isEmpty(String get_date);	// �ش� ��¥ ĭ�� �� ĭ���� Ȯ��
	public List<AdminDTO> allWorkdays();	// �˹� ����� �� ��� ��¥��
	public int insert(AdminDTO dto);		// �˹� ���� �Է�
	public int edit(AdminDTO dto);			// �˹� ���� ����
	public int delete(String date);			// �˹� ���� ����
	public List<AdminDTO> adminList(String get_date);	// �ϴ� �� ������
	public List<ApplyDTO> applyList(String get_date);	// ��û�� ���
	public int status(String date, String id, int applyStatus, int approveStatus);	// ���� or ����
}
