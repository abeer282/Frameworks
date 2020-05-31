using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using SQLiteASPNET;

namespace SQLiteASPNET.Controllers
{
    [Route("api/StudentsInfoes")]
    [ApiController]
    public class StudentsInfoesController : ControllerBase
    {
        private readonly DBInteractor _context;

        public StudentsInfoesController(DBInteractor context)
        {
            _context = context;
        }

        // GET: api/StudentsInfoes
        [HttpGet]
        public IEnumerable<StudentsInfo> GetStudentsInfo()
        {
            return _context.StudentsInfo;
        }

        // GET: api/StudentsInfoes/5
        [HttpGet("{id}")]
        public async Task<IActionResult> GetStudentsInfo([FromRoute] long id)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            var studentsInfo = await _context.StudentsInfo.FindAsync(id);

            if (studentsInfo == null)
            {
                return NotFound();
            }

            return Ok(studentsInfo);
        }

        // PUT: api/StudentsInfoes/5
        [HttpPut("{id}")]
        public async Task<IActionResult> PutStudentsInfo([FromRoute] long id, [FromBody] StudentsInfo studentsInfo)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != studentsInfo.Id)
            {
                return BadRequest();
            }

            _context.Entry(studentsInfo).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!StudentsInfoExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/StudentsInfoes
        [HttpPost]
        public async Task<IActionResult> PostStudentsInfo([FromBody] StudentsInfo studentsInfo)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            _context.StudentsInfo.Add(studentsInfo);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetStudentsInfo", new { id = studentsInfo.Id }, studentsInfo);
        }

        // DELETE: api/StudentsInfoes/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteStudentsInfo([FromRoute] long id)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            var studentsInfo = await _context.StudentsInfo.FindAsync(id);
            if (studentsInfo == null)
            {
                return NotFound();
            }

            _context.StudentsInfo.Remove(studentsInfo);
            await _context.SaveChangesAsync();

            return Ok(studentsInfo);
        }

        private bool StudentsInfoExists(long id)
        {
            return _context.StudentsInfo.Any(e => e.Id == id);
        }
    }
}