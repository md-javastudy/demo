package egovframework.service;

import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.vo.PersonVO;

import java.util.List;

public interface PersonService {

  String insertPerson(PersonVO vo) throws Exception;
  void updatePerson(PersonVO vo) throws Exception;
  void deletePerson(PersonVO vo) throws Exception;
  PersonVO selectPerson(PersonVO vo) throws Exception;
  List<?> selectPersonList(SampleDefaultVO searchVO) throws Exception;
  int selectPersonListTotCnt(SampleDefaultVO searchVO);
}

