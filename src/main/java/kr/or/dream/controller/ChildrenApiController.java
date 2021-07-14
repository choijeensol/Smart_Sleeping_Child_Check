package kr.or.dream.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.or.dream.dto.Children;
import kr.or.dream.service.ChildrenService;
import kr.or.dream.service.RfidService;

@RestController
@RequestMapping(path="/api")
public class ChildrenApiController {
	@Resource
	ChildrenService childrenService;
	
	@GetMapping("/children")
	public List<Children>getChildren(){
		return childrenService.getChildrenAll();
	}
	
	@GetMapping("/child/{no}")
	public Children getChild(@PathVariable Integer no) {
		return childrenService.getChildren(no);
	}
	
	@RequestMapping(path="/child", method=RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public int addChild(@RequestBody Children c) {
		return childrenService.addChlid(c);
	}
	
	//@PutMapping("/child/{id}")
	@RequestMapping(path="/child/{no}", method=RequestMethod.PUT, 
	consumes = MediaType.APPLICATION_JSON_VALUE)
	public int updateChild(@PathVariable Integer no, @RequestBody Children c) {
		c.setNo(no);
		return childrenService.updateChild(c);
	}
	
	@DeleteMapping("/child/{no}")
	public int deleteChild(@PathVariable Integer no) {
		return childrenService.deleteChild(no);
	}
}
