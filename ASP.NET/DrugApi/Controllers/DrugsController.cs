using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using DrugApi.Models;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace DrugApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class DrugsController : Controller
    {
        private readonly DrugContext _context;

        public DrugsController(DrugContext context)
        {
            _context = context;
            if (_context.Drugs.Count() == 0)
            {
                _context.Drugs.Add(new Drug { Name = "Drug1" });
                _context.SaveChanges();
            }
        }



        // GET: api/drug
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Drug>>> GetDrugs()
        {
            return await _context.Drugs.ToListAsync();
        }


        // GET: api/drug/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Drug>> GetDrugs(long id)
        {
            var drug = await _context.Drugs.FindAsync(id);

            if (drug == null)
            {
                return NotFound();
            }

            return drug;
        }
    }
}
