package com.rancher.BeerApplication.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rancher.BeerApplication.BeerException;
import com.rancher.BeerApplication.entity.Beer;
import com.rancher.BeerApplication.service.BeerService;

@Controller
@RequestMapping("/")
public class BeerViewController {
	@Autowired
	BeerService service;

	@RequestMapping
	public String welcome(Model model, @RequestParam("page") Optional<Integer> page) {
		List<Integer> pageNumbers = new ArrayList<>();
		int currentPage = page.orElse(1);
		int pageSize = 20;

		Page<Beer> beerPage = service.findPaginated(PageRequest.of(currentPage - 1, pageSize));

		model.addAttribute("beers", beerPage);

		int totalPages = beerPage.getTotalPages();

		if (totalPages > 0) {
			pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
		}
		model.addAttribute("pageNumbers", pageNumbers);
		return "list-beers";
	}

	@RequestMapping(path = "/search")
	public String search(@RequestParam(value = "id", required = false) String id, Model model) {
		if (id == null || id.length() == 0) {
			return "redirect:/";
		}
		List<Integer> pageNumbers = new ArrayList<>();
		model.addAttribute("pageNumbers", pageNumbers);
		Page<Beer> beerPage = service.findPaginated(PageRequest.of(0, 1), id);
		model.addAttribute("beers", beerPage);

		return "list-beers";
	}

	@RequestMapping(path = "/clear")
	public String clear(Model model) {
		return "redirect:/";
	}

	@RequestMapping(path = "/bulkAdd")
	public String bulkAdd(Model model) {
		service.bulkAdd(1000);
		return "redirect:/";
	}

	@RequestMapping(path = "/bulkDelete")
	public String bulkDelete(Model model) {
		service.bulkDetele(1000);
		return "redirect:/";
	}

	@RequestMapping(path = "/delete/{id}")
	public String deleteBeerById(Model model, @PathVariable("id") String id) throws BeerException {
		service.deleteBeer(id);
		return "redirect:/";
	}

	@RequestMapping(path = "/createBeer", method = RequestMethod.POST)
	public String createOrUpdateBeer(Beer b) {
		b.setUpdated(new Date().toString());
		service.addBeer(b);
		return "redirect:/";
	}

	@RequestMapping(path = { "/edit", "/edit/{id}" })
	public String editBeerById(Model model, @PathVariable("id") Optional<String> id) throws BeerException {
		if (id.isPresent()) {
			Beer b = service.getBeerByID(id.get());
			model.addAttribute("beer", b);
		} else {
			model.addAttribute("beer", new Beer());
		}
		return "add-edit-beer";
	}

}
