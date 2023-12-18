/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import egovframework.example.sample.service.EgovSampleService;
import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.example.sample.service.SampleVO;
import egovframework.service.PersonService;
import egovframework.vo.PersonVO;
import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springmodules.validation.commons.DefaultBeanValidator;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class PersonController {

	@Resource(name = "personService")
	private PersonService personService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	/**
	 * 글 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 SampleDefaultVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/api/listPerson.do",produces = "application/json;charset=UTF8")
	public @ResponseBody String selectPersonList(@ModelAttribute("searchVO") SampleDefaultVO searchVO, ModelMap model) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();

		/** EgovPropertyService.sample */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		List<?> personList = personService.selectPersonList(searchVO);
/*
		model.addAttribute("resultList", personList);

		int totCnt = personService.selectPersonListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
*/
		String result = objectMapper.writeValueAsString(personList);

		return result;
	}

	@RequestMapping(value = "/api/insertPerson.do", method = RequestMethod.POST)
	public @ResponseBody String addSample(@ModelAttribute("searchVO") SampleDefaultVO searchVO, PersonVO personVO, BindingResult bindingResult, Model model, SessionStatus status) throws Exception {

		// Server-Side Validation
		//beanValidator.validate(personVO, bindingResult);

		//if (bindingResult.hasErrors()) {
		//	return "failed";
		//}

		personService.insertPerson(personVO);
		status.setComplete();
		return "success";
	}

	@RequestMapping(value = "/api/viewPerson.do",produces = "application/json;charset=UTF8", method = RequestMethod.POST)
	public @ResponseBody String updatePersonView(@RequestParam("selectedId") Integer id, @ModelAttribute("searchVO") SampleDefaultVO searchVO, Model model) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		PersonVO personVO = new PersonVO();
		personVO.setPsId(id);
		// 변수명은 CoC 에 따라 sampleVO
		return objectMapper.writeValueAsString(selectPerson(personVO, searchVO));
	}

	public PersonVO selectPerson(PersonVO personVO, @ModelAttribute("searchVO") SampleDefaultVO searchVO) throws Exception {
		return personService.selectPerson(personVO);
	}

	@RequestMapping("/api/updatePerson.do")
	public @ResponseBody String updateSample(@ModelAttribute("searchVO") SampleDefaultVO searchVO, PersonVO personVO, BindingResult bindingResult, Model model, SessionStatus status)
			throws Exception {

		beanValidator.validate(personVO, bindingResult);

		if (bindingResult.hasErrors()) {
			return "failed";
		}

		personService.updatePerson(personVO);
		status.setComplete();
		return "success";
	}

	@RequestMapping("/api/deletePerson.do")
	public @ResponseBody String deleteSample(PersonVO personVO, @ModelAttribute("searchVO") SampleDefaultVO searchVO, SessionStatus status) throws Exception {
		personService.deletePerson(personVO);
		status.setComplete();
		return "success";
	}
}
