package com.examples.dev.librarymanagementsystem.service.impl;

import java.util.List;

import com.examples.dev.librarymanagementsystem.entity.Publisher;
import com.examples.dev.librarymanagementsystem.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.examples.dev.librarymanagementsystem.exception.NotFoundException;
import com.examples.dev.librarymanagementsystem.repository.PublisherRepository;

@Service
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	PublisherRepository publisherRepository;

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Publisher> findAllPublishers() {
		return publisherRepository.findAll();
	}

	@Override
	public Publisher findPublisherById(Long id) {
		return publisherRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Publisher not found  with ID %d", id)));
	}

	@Override
	public void createPublisher(Publisher publisher) {
		publisherRepository.save(publisher);
	}

	@Override
	public void updatePublisher(Publisher publisher) {
		publisherRepository.save(publisher);
	}

	@Override
	public void deletePublisher(Long id) {
		var publisher = publisherRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Publisher not found  with ID %d", id)));

		publisherRepository.deleteById(publisher.getId());
	}

}
