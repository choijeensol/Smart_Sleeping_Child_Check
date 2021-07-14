package kr.or.dream.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.dream.dto.Rfid;
import kr.or.dream.service.RfidService;

@RestController
@RequestMapping(path="/api")
public class RfidApiController {
	@Resource
	RfidService rfidService;
	
	@GetMapping("/rfids")
	public List<Rfid> getRfids(){
		return rfidService.getRfidAll();
	}
	
	@GetMapping("/rfid/{hexCode}")
	public Rfid getRfid(@PathVariable String hexCode) {
		return rfidService.getRfid(hexCode);
	}
	
	@PostMapping("/rfid")
	public int addRfid(@RequestBody Rfid rfid) {
		return rfidService.addRfid(rfid);
	}
	
	@PutMapping("/rfid/{hexCode}")
	public int updateRfid(@PathVariable String hexCode, @RequestBody Rfid rfid) {
		rfid.setHexCode(hexCode);
		return rfidService.updateRfid(rfid);
	}
	
	@DeleteMapping("/rfid/{hexCode}")
	public int deleteRfid(@PathVariable String hexCode) {
		return rfidService.deleteRfid(hexCode);
	}
}
