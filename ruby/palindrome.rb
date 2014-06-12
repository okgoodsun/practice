
# Inject new method for String class
class String

  def is_palindrome? 
    s = 0
    e = self.length - 1

    is_palindrome = true
    while s < e
      if self[s] != self[e]
        is_palindrome = false
        break
      end

      s += 1
      e -= 1
    end

    is_palindrome
  end

end

str = ARGV.shift

puts str.is_palindrome?
