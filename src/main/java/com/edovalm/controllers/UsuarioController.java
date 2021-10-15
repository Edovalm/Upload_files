package com.edovalm.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edovalm.entity.Usuario;
import com.edovalm.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/")
	public String form(Model model) {
		model.addAttribute("usuarios", new Usuario());
		return"form";
	}
	
	@PostMapping("/")
	public String guardar(@RequestParam(name = "file", required = false) MultipartFile img_usuario, Usuario usuario,
			RedirectAttributes flash) {
		
		if(!img_usuario.isEmpty()) {
			String ruta = "C://Temp//uploads";
			
			try {
				byte[] bytes = img_usuario.getBytes();
				Path rutaAbsoluta = Paths.get(ruta + "//" + img_usuario.getOriginalFilename());
 				Files.write(rutaAbsoluta, bytes);
 				usuario.setImg_usuario(img_usuario.getOriginalFilename());
 				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			usuarioRepository.save(usuario);
			flash.addFlashAttribute("seccess", "Imagen Subida con Éxito");
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("usuarios", usuarioRepository.findAll());
		return "listar";
	}
}
