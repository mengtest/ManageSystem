package com.uestc.managesystem.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uestc.managesystem.entity.model.PartsFirst;
import com.uestc.managesystem.entity.model.PartsSecond;
import com.uestc.managesystem.mapper.PartsFirstMapper;
import com.uestc.managesystem.mapper.PartsSecondMapper;
import com.uestc.managesystem.service.serviceInter.PartService;

@Service
public class PartServiceImpl implements PartService {

	@Autowired
	private PartsSecondMapper partsSecondMapper;
	
	@Autowired
	private PartsFirstMapper partsFirstMapper;
	
	/**
	 * 查询所有部件分类
	 */
	@Override
	public List<PartsFirst> findAll() {
		// TODO Auto-generated method stub
		List<PartsFirst> result = partsFirstMapper.findAll();
		return result;
	}
	/**
	 * 根据部件ID查询部件分类
	 */
	@Override
	public PartsSecond selectById(int partid) {
		// TODO Auto-generated method stub
		PartsSecond part = partsSecondMapper.selectByPrimaryKey(partid);
		return part;
	}
	/**
	 * 更新部件分类
	 */
	@Override
	public int update(PartsSecond partsSecond) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = partsSecondMapper.updateByPrimaryKeySelective(partsSecond);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("更新事件  "+partsSecond.getPartLId()+" 请检查数据");
		}

		return i;
	}

	/**
	 * 新增部件分类
	 */
	@Override
	public int insert(PartsSecond partsSecond) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = partsSecondMapper.insertSelective(partsSecond);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("添加事件失败, 请检查数据");
		}
		return i;
	}

	/**
	 * 根据部件ID删除部件
	 */
	@Override
	public int remove(int id) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = partsSecondMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("删除事件失败, 请检查数据");
		}
		return i;
	}

}
