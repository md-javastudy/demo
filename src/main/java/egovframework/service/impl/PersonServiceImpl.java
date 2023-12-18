package egovframework.service.impl;

import egovframework.mapper.PersonMapper;
import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.service.PersonService;
import egovframework.vo.PersonVO;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("personService")
public class PersonServiceImpl extends EgovAbstractServiceImpl implements PersonService {

  private static final Logger LOGGER = LoggerFactory.getLogger(egovframework.example.sample.service.impl.EgovSampleServiceImpl.class);

  @Resource(name="personMapper")
  private PersonMapper personDAO;

  @Override
  public String insertPerson(PersonVO vo) throws Exception {
    personDAO.insertPerson(vo);
    return null;
  }

  @Override
  public void updatePerson(PersonVO vo) throws Exception {
    personDAO.updatePerson(vo);
  }

  @Override
  public void deletePerson(PersonVO vo) throws Exception {
    personDAO.deletePerson(vo);
  }

  @Override
  public PersonVO selectPerson(PersonVO vo) throws Exception {
    PersonVO resultVO = personDAO.selectPerson(vo);
    if (resultVO == null)
      throw processException("info.nodata.msg");
    return resultVO;
  }

  /**
   * 글 목록을 조회한다.
   * @param searchVO - 조회할 정보가 담긴 VO
   * @return 글 목록
   * @exception Exception
   */
  @Override
  public List<?> selectPersonList(SampleDefaultVO searchVO) throws Exception {
    return personDAO.selectPersonList(searchVO);
  }

  /**
   * 글 총 갯수를 조회한다.
   * @param searchVO - 조회할 정보가 담긴 VO
   * @return 글 총 갯수
   * @exception
   */
  @Override
  public int selectPersonListTotCnt(SampleDefaultVO searchVO) {
    return personDAO.selectPersonListTotCnt(searchVO);
  }

}

