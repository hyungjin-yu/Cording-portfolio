package notice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import notice.bean.NoticeDTO;
import notice.dao.NoticeDAO;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeDAO dao;

	@Override
	public List<NoticeDTO> noticeList(int startNum, int endNum) {
		return dao.noticeList(startNum, endNum);
	}

	@Override
	public NoticeDTO noticeLatestView() {
		return dao.noticeLatestView();
	}

	@Override
	public NoticeDTO noticeView(int seq) {
		return dao.noticeView(seq);
	}

	@Override
	public int getTotalA() {
		return dao.getTotalA();
	}

	@Override
	public int noticeWrite(NoticeDTO dto) {
		return dao.noticeWrite(dto);
	}

	@Override
	public int noticeModify(NoticeDTO dto) {
		return dao.noticeModify(dto);
	}

	@Override
	public int noticeDelete(int seq) {
		return dao.noticeDelete(seq);
	}

	
	
}
