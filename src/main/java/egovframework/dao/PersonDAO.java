package egovframework.dao;

import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.example.sample.service.SampleVO;
import egovframework.vo.PersonVO;
import org.egovframe.rte.psl.dataaccess.EgovAbstractDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("personDAO")
public class PersonDAO extends EgovAbstractDAO {

	/**
	 * 글을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SampleVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertPerson(PersonVO vo) throws Exception {
		return (String) insert("personDAO.insertPerson", vo);
	}

	/**
	 * 글을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SampleVO
	 * @return void형
	 * @exception Exception
	 */
	public void updatePerson(PersonVO vo) throws Exception {
		update("personDAO.updatePerson", vo);
	}

	/**
	 * 글을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SampleVO
	 * @return void형
	 * @exception Exception
	 */
	public void deletePerson(PersonVO vo) throws Exception {
		delete("personDAO.deletePerson", vo);
	}

	public SampleVO selectPerson(PersonVO vo) throws Exception {
		return (SampleVO) select("personDAO.selectPerson", vo);
	}

	public List<?> selectPersonList(SampleDefaultVO searchVO) throws Exception {
		return list("personDAO.selectPersonList", searchVO);
	}

	public int selectPersonListTotCnt(SampleDefaultVO searchVO) {
		return (Integer) select("personDAO.selectPersonListTotCnt", searchVO);
	}

}
