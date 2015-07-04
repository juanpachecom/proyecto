/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.madal.skorpion.repository;


import cl.madal.skorpion.modelo.Material;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Juan
 */
@Resource(name = "materialRepository") 
public interface MaterialRepository extends JpaRepository<Material, Long >{
    
}