package cat.itacademy.barcelonactiva.munoz.rosario.s05.t01.n01.controller;

import cat.itacademy.barcelonactiva.munoz.rosario.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.munoz.rosario.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.munoz.rosario.s05.t01.n01.model.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("sucursal")
public class SucursalController {

    @Autowired
    public SucursalService sucursalService;

    //Methods for API//

    @PostMapping("/add")
    public ResponseEntity<SucursalDTO> add(@RequestBody SucursalDTO sucursalDTO){
        return new ResponseEntity<SucursalDTO>(sucursalService.add(sucursalDTO),null, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<SucursalDTO> update(@RequestBody SucursalDTO sucursalDTO)  {
        return new ResponseEntity<SucursalDTO>(sucursalService.update(sucursalDTO),null, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        if(sucursalService.delete(id)){
            return new ResponseEntity<String>("Se borro la sucursal " + id,null, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("No se pudo eliminar la sucursal" + id,null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<SucursalDTO> getOne(@PathVariable long id) {
        SucursalDTO sucursalDTO = sucursalService.getOne(id);
        if(sucursalDTO == null){
            return new ResponseEntity<SucursalDTO>(null,null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<SucursalDTO>(sucursalDTO,null, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<ArrayList<SucursalDTO>> getAll() {
        return new ResponseEntity<ArrayList<SucursalDTO>>(sucursalService.getAll(),null, HttpStatus.OK);
    }

    //Methods for Web App//
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("respuesta", this.getAll());
        return "home";
    }

     @GetMapping("/deletePage")
    public String deletePage(@RequestParam Long id) {
        sucursalService.delete(id);
        return "redirect:/sucursal/home";
    }

    @GetMapping("/showAddPage")
    public ModelAndView showAddPage() {
        ModelAndView mav = new ModelAndView("form");
        SucursalDTO nuevaSucursal = new SucursalDTO();
        mav.addObject("sucursal", nuevaSucursal);
        return mav;
    }

    @PostMapping("/addPage")
    public String addPage(@ModelAttribute SucursalDTO sucursalDTO) {
        sucursalService.add(sucursalDTO);
        return "redirect:/sucursal/home";
    }

    @GetMapping("/showEditPage")
    public ModelAndView showEditPage(@RequestParam Long id) {
        ModelAndView mav = new ModelAndView("form");
        SucursalDTO sucursalExistente = sucursalService.getOne(id);
        mav.addObject("sucursal", sucursalExistente);
        return mav;
    }

}

